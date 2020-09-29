package ng.com.systemspecs.dto;

import java.io.Serializable;


public class BulkPaymentStatusResponse implements Serializable {

    private PaymentStatusBulk data;

    private String status;


    public PaymentStatusBulk getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public void setData(PaymentStatusBulk data) {
        this.data = data;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
