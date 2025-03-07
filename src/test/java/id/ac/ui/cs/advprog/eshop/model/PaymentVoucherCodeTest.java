package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentVoucherCodeTest {
    private Map<String, String> paymentData;
    private List<Product> products;
    private Order order;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
        this.products = new ArrayList<>();
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(2);
        products.add(product);
        this.order = new Order("eb558e9f-1c39-460e-8860-54eb1396d79b", this.products, 1708560000L, "Tatang Sudrajat");
    }

    @Test
    void testCreatePaymentWithEmptyPaymentData() {
        paymentData.clear();
        assertThrows(IllegalArgumentException.class, () ->
                new PaymentVoucherCode("payment-123", order, paymentData)
        );
    }

    @Test
    void testCreatePaymentWithValidVoucherCode() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        PaymentVoucherCode payment = new PaymentVoucherCode("payment-123", order, paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidVoucherCode() {
        paymentData.put("voucherCode", "INVALID_CODE");
        PaymentVoucherCode payment = new PaymentVoucherCode("payment-123", order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        PaymentVoucherCode payment = new PaymentVoucherCode("payment-123", order, paymentData, PaymentStatus.SUCCESS.getValue());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidVoucherCodeTooShort() {
        paymentData.put("voucherCode", "ESHOP1234ABC567"); // 15 chars instead of 16
        PaymentVoucherCode payment = new PaymentVoucherCode("payment-123", order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidVoucherCodeWrongPrefix() {
        paymentData.put("voucherCode", "SHOP1234ABC5678");
        PaymentVoucherCode payment = new PaymentVoucherCode("payment-123", order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidVoucherCodeNotEnoughNumbers() {
        paymentData.put("voucherCode", "ESHOP12ABCD5678");
        PaymentVoucherCode payment = new PaymentVoucherCode("payment-123", order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithInvalidVoucherCodeTooManyNumbers() {
        paymentData.put("voucherCode", "ESHOP123456789012");
        PaymentVoucherCode payment = new PaymentVoucherCode("payment-123", order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithEmptyVoucherCode() {
        paymentData.put("voucherCode", "");
        PaymentVoucherCode payment = new PaymentVoucherCode("payment-123", order, paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }
}