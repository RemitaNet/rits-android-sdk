package ng.com.systemspecs.dto.bulkpayment.status;

import java.io.Serializable;


public class BulkPaymentStatusRequest implements Serializable {

    private String batchRef;


    public String getBatchRef() {
        return batchRef;
    }


    public void setBatchRef(String batchRef) {
        this.batchRef = batchRef;
    }
}
