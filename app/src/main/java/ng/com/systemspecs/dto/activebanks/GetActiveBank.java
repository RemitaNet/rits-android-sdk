package ng.com.systemspecs.dto.activebanks;

import java.io.Serializable;
import java.util.List;


public class GetActiveBank implements Serializable {

    private List<Banks> banks;

    private String responseCode;

    private String responseDescription;

    private String responseId;


    public List<Banks> getBanks() {
        return banks;
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


    public void setBanks(List<Banks> banks) {
        this.banks = banks;
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
