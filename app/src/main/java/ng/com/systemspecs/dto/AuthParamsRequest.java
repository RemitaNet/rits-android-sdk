package ng.com.systemspecs.dto;

import java.io.Serializable;


public class AuthParamsRequest implements Serializable {

    private String param1;

    private String value;


    public String getParam1() {
        return param1;
    }


    public String getValue() {
        return value;
    }


    public void setParam1(String param1) {
        this.param1 = param1;
    }


    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "AuthParamsRequest [value = " + value + ", param1 = " + param1 + "]";
    }
}
