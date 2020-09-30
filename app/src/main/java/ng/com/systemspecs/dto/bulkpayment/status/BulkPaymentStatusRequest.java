package ng.com.systemspecs.dto.bulkpayment.status;

import java.io.Serializable;


public class BulkPaymentStatusRequest implements Serializable {

    private String batchRef;
    private String transRef;


    public String getBatchRef() {
        return batchRef;
    }

    public void setBatchRef(String batchRef) {
        this.batchRef = batchRef;
    }

    public String getTransRef() {
        return transRef;
    }

    public void setTransRef(String transRef) {
        this.transRef = transRef;
    }
}
