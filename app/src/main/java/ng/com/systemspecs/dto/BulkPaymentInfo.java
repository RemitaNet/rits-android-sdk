package ng.com.systemspecs.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class BulkPaymentInfo implements Serializable {

    private String bankCode;

    private String batchRef;

    private String debitAccount;

    private String narration;

    private String totalAmount;

    private String remitaFunded;

    private String generateRrrOnly;


    public String getBankCode() {
        return bankCode;
    }


    public String getBatchRef() {
        return batchRef;
    }


    public String getDebitAccount() {
        return debitAccount;
    }


    public String getNarration() {
        return narration;
    }


    public String getTotalAmount() {
        return totalAmount;
    }

    public String getRemitaFunded() {
        return remitaFunded;
    }

    public String getGenerateRrrOnly() {
        return generateRrrOnly;
    }


    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }


    public void setBatchRef(String batchRef) {
        this.batchRef = batchRef;
    }


    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }


    public void setNarration(String narration) {
        this.narration = narration;
    }


    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setRemitaFunded(String remitaFunded) {
        this.remitaFunded = remitaFunded;
    }

    public void setGenerateRrrOnly(String generateRrrOnly) {
        this.generateRrrOnly = generateRrrOnly;
    }
}
