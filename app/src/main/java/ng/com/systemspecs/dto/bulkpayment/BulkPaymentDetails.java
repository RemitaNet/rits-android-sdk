package ng.com.systemspecs.dto.bulkpayment;

import java.io.Serializable;
import java.math.BigDecimal;


public class BulkPaymentDetails implements Serializable {

    private String amount;

    private String authorizationId;

    private String paymentDate;

    private String paymentReference;

    private String paymentState;

    private String responseCode;

    private String responseMessage;

    private String statusCode;

    private String statusMessage;

    private String transDate;

    private String transRef;


    public String getAmount() {
        return amount;
    }


    public String getAuthorizationId() {
        return authorizationId;
    }


    public String getPaymentDate() {
        return paymentDate;
    }


    public String getPaymentReference() {
        return paymentReference;
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


    public String getTransDate() {
        return transDate;
    }


    public String getTransRef() {
        return transRef;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }


    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }


    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }


    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
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


    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }


    public void setTransRef(String transRef) {
        this.transRef = transRef;
    }


    @Override
    public String toString() {
        return "BulkPaymentDetails [amount = " + amount + ", transRef = " + transRef + ", paymentReference = " + paymentReference + ", authorizationId = "
                + authorizationId + ", transDate = " + transDate + ", paymentDate = " + paymentDate + ", paymentState = " + paymentState
                + ", responseMessage = " + responseMessage + ", statusMessage = " + statusMessage + ", statusCode = " + statusCode + ", responseCode = "
                + responseCode + "]";
    }
}
