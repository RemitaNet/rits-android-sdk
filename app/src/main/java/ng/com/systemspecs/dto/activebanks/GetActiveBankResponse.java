package ng.com.systemspecs.dto.activebanks;

import java.io.Serializable;


public class GetActiveBankResponse implements Serializable {

    private GetActiveBank data;

    private String status;


    public GetActiveBank getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public void setData(GetActiveBank data) {
        this.data = data;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
