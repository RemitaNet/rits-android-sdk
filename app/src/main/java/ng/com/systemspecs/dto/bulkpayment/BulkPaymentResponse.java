package ng.com.systemspecs.dto.bulkpayment;

import java.io.Serializable;


public class BulkPaymentResponse implements Serializable {

    private BulkPayment data;

    private String status;


    public BulkPayment getData() {
        return data;
    }


    public String getStatus() {
        return status;
    }


    public void setData(BulkPayment data) {
        this.data = data;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
