package ng.com.systemspecs.dto;

import java.math.BigDecimal;


public class PaymentStatus {

    private BigDecimal amount;

    private String authorizationId;

    private String creditAccount;

    private String currencyCode;

    private String debitAccount;

    private BigDecimal feeAmount;

    private String narration;

    private String paymentDate;

    private String paymentState;

    private String paymentStatus;

    private String paymentStatusCode;

    private String responseCode;

    private String responseDescription;

    private String settlementDate;

    private String toBank;

    private String transRef;


    public BigDecimal getAmount() {
        return amount;
    }


    public String getAuthorizationId() {
        return authorizationId;
    }


    public String getCreditAccount() {
        return creditAccount;
    }


    public String getCurrencyCode() {
        return currencyCode;
    }


    public String getDebitAccount() {
        return debitAccount;
    }


    public BigDecimal getFeeAmount() {
        return feeAmount;
    }


    public String getNarration() {
        return narration;
    }


    public String getPaymentDate() {
        return paymentDate;
    }


    public String getPaymentState() {
        return paymentState;
    }


    public String getPaymentStatus() {
        return paymentStatus;
    }


    public String getPaymentStatusCode() {
        return paymentStatusCode;
    }


    public String getResponseCode() {
        return responseCode;
    }


    public String getResponseDescription() {
        return responseDescription;
    }


    public String getSettlementDate() {
        return settlementDate;
    }


    public String getToBank() {
        return toBank;
    }


    public String getTransRef() {
        return transRef;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }


    public void setCreditAccount(String creditAccount) {
        this.creditAccount = creditAccount;
    }


    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


    public void setDebitAccount(String debitAccount) {
        this.debitAccount = debitAccount;
    }


    public void setFeeAmount(BigDecimal feeAmount) {
        this.feeAmount = feeAmount;
    }


    public void setNarration(String narration) {
        this.narration = narration;
    }


    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }


    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }


    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    public void setPaymentStatusCode(String paymentStatusCode) {
        this.paymentStatusCode = paymentStatusCode;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }


    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }


    public void setToBank(String toBank) {
        this.toBank = toBank;
    }


    public void setTransRef(String transRef) {
        this.transRef = transRef;
    }


    @Override
    public String toString() {
        return "ClassPojo [amount = " + amount + ", debitAccount = " + debitAccount + ", creditAccount = " + creditAccount + ", authorizationId = "
                + authorizationId + ", settlementDate = " + settlementDate + ", responseCode = " + responseCode + ", feeAmount = " + feeAmount
                + ", paymentStatusCode = " + paymentStatusCode + ", transRef = " + transRef + ", responseDescription = " + responseDescription
                + ", narration = " + narration + ", toBank = " + toBank + ", paymentDate = " + paymentDate + ", paymentState = " + paymentState
                + ", currencyCode = " + currencyCode + ", paymentStatus = " + paymentStatus + "]";
    }
}
