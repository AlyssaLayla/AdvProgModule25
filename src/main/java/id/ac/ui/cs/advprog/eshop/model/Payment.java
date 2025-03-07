package id.ac.ui.cs.advprog.eshop.model;
import lombok.Getter;
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
}