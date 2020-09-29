package ng.com.systemspecs.config;

import java.io.Serializable;


public class Credentials implements Serializable {


    private String apiKey;

    private String apiToken;

    private String merchantId;

    private String secretKey;

    private String secretKeyIv;

    private int readTimeOut = 5000;

    private int connectionTimeOut = 15000;

    private String requestId;



    public String getRequestId() {
        return requestId;
    }


    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }



    public void setConnectionTimeOut(int connectionTimeOut) {
        this.connectionTimeOut = connectionTimeOut;
    }

    public int getConnectionTimeOut() {
        return connectionTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public int getReadTimeOut() {
        return readTimeOut;
    }


    public String getEnvironment() {
        return environment;
    }


    public void setEnvironment(String environment) {
        this.environment = environment;
    }



    private String environment = "TEST";


    public String getApiKey() {
        return apiKey;
    }


    public String getApiToken() {
        return apiToken;
    }


    public String getMerchantId() {
        return merchantId;
    }


    public String getSecretKey() {
        return secretKey;
    }


    public String getSecretKeyIv() {
        return secretKeyIv;
    }


    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }


    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }


    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }


    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }


    public void setSecretKeyIv(String secretKeyIv) {
        this.secretKeyIv = secretKeyIv;
    }


}
