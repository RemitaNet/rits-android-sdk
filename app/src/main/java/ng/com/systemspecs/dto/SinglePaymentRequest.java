package ng.com.systemspecs.dto;

import java.io.Serializable;
import java.math.BigDecimal;


public class SinglePaymentRequest implements Serializable {

    private String toBank;
    private String creditAccount;
    private String narration;
    private String amount;
    private String transRef;
    private String fromBank;
    private String debitAccount;
    private String beneficiaryEmail;

    public String getAmount() {
        return amount;
    }


    public String getBeneficiaryEmail() {
        return beneficiaryEmail;
    }


    public String getCreditAccount() {
        return creditAccount;
    }


    public String getDebitAccount() {
        return debitAccount;
    }


    public String getFromBank() {
        return fromBank;
    }


    public String getNarration() {
        return narration;
    }


    public String getToBank() {
        return toBank;
    }


    public String getTransRef() {
        return transRef;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public void setBeneficiaryEmail(String beneficiaryEmail) {
        this.beneficiaryEmail = beneficiaryEmail;
    }


    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
    }


    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }


    public void setFromBank(String fromBank) {
        this.fromBank = fromBank;
    }


    public void setNarration(String narration) {
        this.narration = narration;
    }


    public void setToBank(String toBank) {
        this.toBank = toBank;
    }

    public void setTransRef(String transRef) {
        this.transRef = transRef;
    }
}
