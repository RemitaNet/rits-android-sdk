package ng.com.systemspecs.dto.bulkpayment.status;

import java.io.Serializable;


public class BulkPaymentStatusResponse implements Serializable {

    private BulkPaymentStatus data;

    private String status;


    public BulkPaymentStatus getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public void setData(BulkPaymentStatus data) {
        this.data = data;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
