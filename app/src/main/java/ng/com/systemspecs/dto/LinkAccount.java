package ng.com.systemspecs.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LinkAccount {

    private static final String LINK_ACCOUNT_RESPONSE_PARAM1 = "OTP";

    private static final String LINK_ACCOUNT_RESPONSE_PARAM1_DESCRIPTION = "Please provide the OTP sent to you by your bank";

    private static final String LINK_ACCOUNT_RESPONSE_PARAM2 = "CARD";

    private static final String LINK_ACCOUNT_RESPONSE_PARAM2_DESCRIPTION = "Please provide the last 4 digits of you card";

    private List<Map<String, String>> authParams = new ArrayList<>();

    private String mandateNumber;

    private String remitaTransRef;

    private String responseCode;

    private String responseDescription;

    private String responseId;


    public List<Map<String, String>> getAuthParams() {
        return authParams;
    }


    public String getMandateNumber() {
        return mandateNumber;
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


    public void setAuthParams(List<Map<String, String>> authParams) {
        this.authParams = authParams;
    }


    public void setMandateNumber(String mandateNumber) {
        this.mandateNumber = mandateNumber;
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
}
