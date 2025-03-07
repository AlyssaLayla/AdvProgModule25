package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;

public class PaymentVoucherCode extends Payment {
    public PaymentVoucherCode(String id, Order order, Map<String, String> paymentData) {
        super(id, "VoucherCode", order, paymentData);
    }

    public PaymentVoucherCode(String id, Order order, Map<String, String> paymentData, String status) {
        super(id, "VoucherCode", order, paymentData, status);
    }
}