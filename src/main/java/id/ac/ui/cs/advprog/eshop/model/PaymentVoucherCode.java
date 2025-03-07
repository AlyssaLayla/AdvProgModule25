package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;

public class PaymentVoucherCode extends Payment {
    public PaymentVoucherCode(String id, Order order, Map<String, String> paymentData) {
        super(id, "VoucherCode", order, paymentData, validateVoucher(paymentData.get("voucherCode")));
    }

    public PaymentVoucherCode(String id, Order order, Map<String, String> paymentData, String status) {
        super(id, "VoucherCode", order, paymentData, status);
    }

    private static String validateVoucher(String voucherCode) {
        if (voucherCode != null && voucherCode.length() == 16 &&
                voucherCode.startsWith("ESHOP") &&
                voucherCode.replaceAll("\\D", "").length() == 8) {
            return "SUCCESS";
        }
        return "REJECTED";
    }
}