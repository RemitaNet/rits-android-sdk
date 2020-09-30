package ng.com.systemspecs.dto.singlepayment.status;

import java.io.Serializable;


public class PaymentStatusResponse implements Serializable {

    private PaymentStatus data;

    private String status;


    public PaymentStatus getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public void setData(PaymentStatus data) {
        this.data = data;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
