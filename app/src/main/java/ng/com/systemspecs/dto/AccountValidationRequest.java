package ng.com.systemspecs.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AccountValidationRequest implements Serializable {

    private List<AuthParamsRequest> authParams = new ArrayList<>();

    private String remitaTransRef;


    public List<AuthParamsRequest> getAuthParams() {
        return authParams;
    }


    public String getRemitaTransRef() {
        return remitaTransRef;
    }


    public void setAuthParams(List<AuthParamsRequest> authParams) {
        this.authParams = authParams;
    }


    public void setRemitaTransRef(String remitaTransRef) {
        this.remitaTransRef = remitaTransRef;
    }
}
