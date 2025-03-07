package id.ac.ui.cs.advprog.eshop.model;
import lombok.Getter;
import java.util.Map;
import java.util.Arrays;

@Getter
public class Payment {
    private String id;
    private String method;
    private Order order;
    private Map<String, String> paymentData;
    private String status;


    public Payment(String id, String method, Order order, Map<String, String> paymentData) {
        this.id = id;
        this.status = "REJECTED";

        if (method.equals("VoucherCode") || method.equals("BankTransfer")) {
            this.method = method;
        } else {
            throw new IllegalArgumentException();
        }

        if (order == null) {
            throw new IllegalArgumentException();
        } else {
            this.order = order;
        }

        if (paymentData == null || paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }
    }

    public Payment(String id, String method, Order order, Map<String, String> paymentData, String status) {

        this(id, method, order, paymentData);
        String[] statusList = {"SUCCESS", "REJECTED"};
        if (Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }

    public void setStatus(String status) {
        String[] statusList = {"SUCCESS", "REJECTED"};
        if (Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }

    public void setPaymentData(Map<String, String> paymentData) {
        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }
    }
}