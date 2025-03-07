package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentTest {
    private Map<String, String> paymentData;
    private List<Product> products;
    private Order order;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
        this.paymentData.put("voucherCode", "ESHOP1234ABC5678");

        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);

        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);

        this.products.add(product1);
        this.products.add(product2);

        this.order = new Order("eb558e9f-1c39-460e-8860-54eb1396d79b", this.products, 1708560000L, "Tatang Sudrajat");
    }

    @Test
    void testCreatePaymentEmptyPaymentData(){
        paymentData.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("eb558e9f-1c39-460e-8860-54eb1396d79b", "VoucherCode", order, paymentData);
        });
    }

    @Test
    void testCreatePaymentDefaultValue() {
        Payment payment = new Payment("eb558e9f-1c39-460e-8860-54eb1396d79b", "VoucherCode", order, paymentData);

        assertEquals("eb558e9f-1c39-460e-8860-54eb1396d79b" ,payment.getId());
        assertEquals("VoucherCode", payment.getMethod());
        assertSame(order, payment.getOrder());
        assertSame(paymentData, payment.getPaymentData());
    }

    @Test
    void testCreatePaymentInvalidMethod(){
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("eb558e9f-1c39-460e-8860-54eb1396d79b", "InvalidMethod", order, paymentData);
        });
    }

    @Test
    void testCreatePaymentEmptyOrder(){
        paymentData.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment("eb558e9f-1c39-460e-8860-54eb1396d79b", "VoucherCode", null, paymentData);
        });
    }

}