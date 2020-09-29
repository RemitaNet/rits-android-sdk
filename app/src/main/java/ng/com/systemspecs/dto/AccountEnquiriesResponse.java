package ng.com.systemspecs.dto;

public class AccountEnquiriesResponse {

    private AccountEnquiries data;

    private String status;


    public AccountEnquiries getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public void setData(AccountEnquiries data) {
        this.data = data;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
