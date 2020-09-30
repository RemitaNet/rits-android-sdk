package ng.com.systemspecs.dto.accountenquiry;

public class AccountEnquiryResponse {

    private AccountEnquiry data;

    private String status;


    public AccountEnquiry getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public void setData(AccountEnquiry data) {
        this.data = data;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
