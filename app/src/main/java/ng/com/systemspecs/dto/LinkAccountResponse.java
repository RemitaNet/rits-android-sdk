package ng.com.systemspecs.dto;

public class LinkAccountResponse {

    private LinkAccount data;

    private String status;


    public LinkAccount getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public void setData(LinkAccount data) {
        this.data = data;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
