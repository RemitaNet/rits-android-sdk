package ng.com.systemspecs.dto;

import java.io.Serializable;


public class AccountValidationResponse implements Serializable {

    private AccountValidation data;

    private String status;


    public AccountValidation getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public void setData(AccountValidation data) {
        this.data = data;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "AccountValidationResponse [data = " + data + ", status = " + status + "]";
    }
}
