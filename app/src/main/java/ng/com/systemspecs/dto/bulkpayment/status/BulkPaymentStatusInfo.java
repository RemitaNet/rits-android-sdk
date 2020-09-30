package ng.com.systemspecs.dto.bulkpayment.status;

import java.io.Serializable;
import java.math.BigDecimal;


public class BulkPaymentStatusInfo implements Serializable {

    private String currencyCode;

    private String debitAccountToken;

    private String feeAmount;

    private String paymentState;

    private String responseCode;

    private String responseMessage;

    private String statusCode;

    private String statusMessage;

    private String totalAmount;


    public String getCurrencyCode() {
        return currencyCode;
    }


    public String getDebitAccountToken() {
        return debitAccountToken;
    }


    public String getFeeAmount() {
        return feeAmount;
    }


    public String getPaymentState() {
        return paymentState;
    }


    public String getResponseCode() {
        return responseCode;
    }


    public String getResponseMessage() {
        return responseMessage;
    }


    public String getStatusCode() {
        return statusCode;
    }


    public String getStatusMessage() {
        return statusMessage;
    }


    public String getTotalAmount() {
        return totalAmount;
    }


    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


    public void setDebitAccountToken(String debitAccountToken) {
        this.debitAccountToken = debitAccountToken;
    }


    public void setFeeAmount(String  feeAmount) {
        this.feeAmount = feeAmount;
    }


    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }


    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }


    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }


    public void setTotalAmount(String  totalAmount) {
        this.totalAmount = totalAmount;
    }


    @Override
    public String toString() {
        return "BulkPaymentStatusInfo [debitAccountToken = " + debitAccountToken + ", totalAmount = " + totalAmount + ", feeAmount = " + feeAmount
                + ", responseMessage = " + responseMessage + ", paymentState = " + paymentState + ", currencyCode = " + currencyCode + ", statusMessage = "
                + statusMessage + ", statusCode = " + statusCode + ", responseCode = " + responseCode + "]";
    }
}
