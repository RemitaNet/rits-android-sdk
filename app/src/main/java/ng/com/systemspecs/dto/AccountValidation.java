package ng.com.systemspecs.dto;

import java.io.Serializable;


public class AccountValidation implements Serializable {

    private String accountToken;

    private String remitaTransRef;

    private String responseCode;

    private String responseDescription;

    private String responseId;


    public String getAccountToken() {
        return accountToken;
    }


    public String getRemitaTransRef() {
        return remitaTransRef;
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


    public void setAccountToken(String accountToken) {
        this.accountToken = accountToken;
    }


    public void setRemitaTransRef(String remitaTransRef) {
        this.remitaTransRef = remitaTransRef;
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


    @Override
    public String toString() {
        return "AccountValidation [responseDescription = " + responseDescription + ", remitaTransRef = " + remitaTransRef + ", accountToken = " + accountToken
                + ", responseId = " + responseId + ", responseCode = " + responseCode + "]";
    }
}
