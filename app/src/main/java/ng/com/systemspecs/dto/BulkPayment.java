package ng.com.systemspecs.dto;

import java.io.Serializable;


public class BulkPayment implements Serializable {

    private String authorizationId;

    private String data;

    private String paymentDate;

    private String responseCode;

    private String responseDescription;

    private String responseId;

    private String rrr;

    private String transRef;


    public String getAuthorizationId() {
        return authorizationId;
    }


    public String getData() {
        return data;
    }


    public String getPaymentDate() {
        return paymentDate;
    }


    public String getResponseCode() {
        return responseCode;
    }


    public String getResponseDescription() {
        return responseDescription;
    }


    public String getResponseId() {
        return responseId;
    }


    public String getRrr() {
        return rrr;
    }


    public String getTransRef() {
        return transRef;
    }


    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }


    public void setData(String data) {
        this.data = data;
    }


    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }


    public void setResponseId(String responseId) {
        this.responseId = responseId;
    }


    public void setRrr(String rrr) {
        this.rrr = rrr;
    }


    public void setTransRef(String transRef) {
        this.transRef = transRef;
    }
}
