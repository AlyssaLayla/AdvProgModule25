package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import lombok.Getter;
import java.util.Map;

@Getter
public class PaymentBankTransfer extends Payment {
    public PaymentBankTransfer(String id, Order order, Map<String, String> paymentData) {
        super(id, "BankTransfer", order, paymentData, validateBankTransfer(paymentData));
    }

    public PaymentBankTransfer(String id, Order order, Map<String, String> paymentData, String status) {
        super(id, "BankTransfer", order, paymentData, status);
    }

    private static String validateBankTransfer(Map<String, String> paymentData) {
        String bankName = paymentData.get("bankName");
        String referenceCode = paymentData.get("referenceCode");

        if (bankName == null || bankName.isEmpty() || referenceCode == null || referenceCode.isEmpty()) {
            return PaymentStatus.REJECTED.getValue();
        }
        return PaymentStatus.SUCCESS.getValue();
    }
}