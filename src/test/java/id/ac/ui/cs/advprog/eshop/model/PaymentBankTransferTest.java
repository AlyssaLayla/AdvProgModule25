package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PaymentBankTransferTest {
    private Map<String, String> paymentData;
    private List<Product> products;
    private Order order;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
        this.paymentData.put("bankName", "Bank UI");
        this.paymentData.put("referenceCode", "REF123456");

        this.products = new ArrayList<>();
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(2);
        this.products.add(product);

        this.order = new Order("order-123", this.products, 1708560000L, "Tatang Sudrajat");
    }

    @Test
    void testCreatePaymentWithValidBankTransfer() {
        PaymentBankTransfer payment = new PaymentBankTransfer("payment-123", order, new HashMap<>(paymentData));
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithMissingBankName() {
        Map<String, String> testData = new HashMap<>(paymentData);
        testData.remove("bankName");
        PaymentBankTransfer payment = new PaymentBankTransfer("payment-123", order, testData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithMissingReferenceCode() {
        Map<String, String> testData = new HashMap<>(paymentData);
        testData.remove("referenceCode");
        PaymentBankTransfer payment = new PaymentBankTransfer("payment-123", order, testData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithEmptyBankName() {
        Map<String, String> testData = new HashMap<>(paymentData);
        testData.put("bankName", "");
        PaymentBankTransfer payment = new PaymentBankTransfer("payment-123", order, testData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithEmptyReferenceCode() {
        Map<String, String> testData = new HashMap<>(paymentData);
        testData.put("referenceCode", "");
        PaymentBankTransfer payment = new PaymentBankTransfer("payment-123", order, testData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreatePaymentWithCustomStatus() {
        PaymentBankTransfer payment = new PaymentBankTransfer("payment-123", order, new HashMap<>(paymentData), PaymentStatus.PENDING.getValue());
        assertEquals(PaymentStatus.PENDING.getValue(), payment.getStatus());
    }
}
