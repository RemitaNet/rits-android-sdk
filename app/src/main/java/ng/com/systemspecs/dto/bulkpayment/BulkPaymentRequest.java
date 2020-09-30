package ng.com.systemspecs.dto.bulkpayment;

import java.io.Serializable;
import java.util.List;


public class BulkPaymentRequest implements Serializable {

    private BulkPaymentInfo bulkPaymentInfo;

    private List<PaymentDetails> paymentDetails;


    public BulkPaymentInfo getBulkPaymentInfo() {
        return bulkPaymentInfo;
    }


    public List<PaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }


    public void setBulkPaymentInfo(BulkPaymentInfo bulkPaymentInfo) {
        this.bulkPaymentInfo = bulkPaymentInfo;
    }


    public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
