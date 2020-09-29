package ng.com.systemspecs.config;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ng.com.systemspecs.dto.PaymentStatus;
import ng.com.systemspecs.dto.PaymentStatusRequest;
import ng.com.systemspecs.dto.PaymentStatusResponse;
import ng.com.systemspecs.dto.SinglePayment;
import ng.com.systemspecs.dto.SinglePaymentRequest;
import ng.com.systemspecs.dto.SinglePaymentResponse;
import ng.com.systemspecs.service.AbstractRestClient;
import ng.com.systemspecs.utils.FieldEncryptionService;
import ng.com.systemspecs.utils.JsonUtil;


public class RemitaRITSService {


    public static String algorithm = "AES";

    public static String cipher = "AES/CBC/PKCS5PADDING";

    private static DateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

    Gson gson = new Gson();

    Credentials credentials;

    public RemitaRITSService() {
    }

    public RemitaRITSService(Credentials credentials) {
        this.credentials = credentials;
        restTemplate = commonsRestTemplate(credentials);
    }


    RestTemplate restTemplate = new RestTemplate();

    public PaymentStatusResponse singlePaymentStatus(PaymentStatusRequest request) throws Exception {
        PaymentStatusResponse paymentStatusResponse = null;
        String url = null;
        if (!ConfigCredentials.isCredential(credentials)) {
            PaymentStatus data = new PaymentStatus();
            PaymentStatusResponse response = new PaymentStatusResponse();
            data.setResponseCode(ConfigCredentials.emptyCredentialsResponseCode);
            data.setResponseDescription(ConfigCredentials.emptyCredentialsMessage);
            response.setStatus(ConfigCredentials.credentialStatus);
            response.setData(data);
            return response;
        }
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
            url = ApplicationUrl.LIVE;
        } else {
            url = ApplicationUrl.DEMO;
        }

        return paymentStatusResponse;
    }

    public SinglePaymentResponse singlePayment(SinglePaymentRequest request) throws Exception {

        String url = null;

        if (!ConfigCredentials.isCredential(credentials)) {
            SinglePayment data = new SinglePayment();
            SinglePaymentResponse response = new SinglePaymentResponse();
            data.setResponseCode(ConfigCredentials.emptyCredentialsResponseCode);
            data.setResponseDescription(ConfigCredentials.emptyCredentialsMessage);
            response.setStatus(ConfigCredentials.credentialStatus);
            response.setData(data);
            return response;
        }
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
            url = ApplicationUrl.LIVE;
        } else {
            url = ApplicationUrl.DEMO;
        }
        url = url + ApplicationUrl.SINGLE_PAYMENT;

        Log.v("+++ Request ", JsonUtil.toJson(request));
        Log.v("","");

        request = FieldEncryptionService.encryptSinglePaymentFields(request, credentials);

        SinglePaymentResponse singlePaymentResponse = null;
        String response = null;

        response = AbstractRestClient.postRequest(url, request, credentials);
        singlePaymentResponse = JsonUtil.fromJson(response, SinglePaymentResponse.class);


        return singlePaymentResponse;
    }

    public RestTemplate commonsRestTemplate(Credentials credentials) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(credentials.getConnectionTimeOut());
        factory.setReadTimeout(credentials.getReadTimeOut());
        return new RestTemplate(factory);
    }
}
