package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import java.util.Map;

@Getter
public class Payment {
    private String id;
    private String method;
    private Order order;
    private Map<String, String> paymentData;
    private String status;

    public Payment(String id, String method, Order order, Map<String, String> paymentData) {
        this.id = id;
        this.status = PaymentStatus.REJECTED.getValue();

        if (method.equals("VoucherCode") || method.equals("BankTransfer")) {
            this.method = method;
        } else {
            throw new IllegalArgumentException("Invalid payment method");
        }

        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        } else {
            this.order = order;
        }

        if (paymentData == null || paymentData.isEmpty()) {
            throw new IllegalArgumentException("Payment data cannot be empty");
        } else {
            this.paymentData = paymentData;
        }
    }

    public Payment(String id, String method, Order order, Map<String, String> paymentData, String status) {
        this(id, method, order, paymentData);
        if (!PaymentStatus.contains(status)) {
            throw new IllegalArgumentException("Invalid payment status");
        } else {
            this.setStatus(status);
        }
    }

    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }


    public void setPaymentData(Map<String, String> paymentData) {
        if (paymentData == null || paymentData.isEmpty()) {
            throw new IllegalArgumentException("Payment data cannot be empty");
        } else {
            this.paymentData = paymentData;
        }
    }
}
