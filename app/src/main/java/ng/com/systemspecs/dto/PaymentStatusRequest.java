package ng.com.systemspecs.dto;

import java.io.Serializable;


public class PaymentStatusRequest implements Serializable {

    private String transRef;


    public String getTransRef() {
        return transRef;
    }


    public void setTransRef(String transRef) {
        this.transRef = transRef;
    }
}
