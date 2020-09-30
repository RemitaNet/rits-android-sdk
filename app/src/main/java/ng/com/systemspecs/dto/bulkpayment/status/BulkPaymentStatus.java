package ng.com.systemspecs.dto.bulkpayment.status;

import java.io.Serializable;
import java.util.List;

import ng.com.systemspecs.dto.bulkpayment.BulkPaymentDetails;
import ng.com.systemspecs.dto.bulkpayment.status.BulkPaymentStatusInfo;


public class BulkPaymentStatus implements Serializable {

    private String batchRef;

    private BulkPaymentStatusInfo bulkPaymentStatusInfo;

    private String bulkRef;

    private List<BulkPaymentDetails> paymentDetails;


    public String getBatchRef() {
        return batchRef;
    }


    public BulkPaymentStatusInfo getBulkPaymentStatusInfo() {
        return bulkPaymentStatusInfo;
    }


    public String getBulkRef() {
        return bulkRef;
    }


    public List<BulkPaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }


    public void setBatchRef(String batchRef) {
        this.batchRef = batchRef;
    }


    public void setBulkPaymentStatusInfo(BulkPaymentStatusInfo bulkPaymentStatusInfo) {
        this.bulkPaymentStatusInfo = bulkPaymentStatusInfo;
    }


    public void setBulkRef(String bulkRef) {
        this.bulkRef = bulkRef;
    }


    public void setPaymentDetails(List<BulkPaymentDetails> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
