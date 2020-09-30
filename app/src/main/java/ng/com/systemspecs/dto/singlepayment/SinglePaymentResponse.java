package ng.com.systemspecs.dto.singlepayment;

import java.io.Serializable;


public class SinglePaymentResponse implements Serializable {

    private SinglePayment data;

    private String status;


    public SinglePayment getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public void setData(SinglePayment data) {
        this.data = data;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
