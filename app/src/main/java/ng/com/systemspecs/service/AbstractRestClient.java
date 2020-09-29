package ng.com.systemspecs.service;

import android.util.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import ng.com.systemspecs.config.Credentials;
import ng.com.systemspecs.utils.JsonUtil;
import ng.com.systemspecs.utils.SimpleSHAHashGenerator;

public class AbstractRestClient {

    public static int HTTP_CONNECT_TIMEOUT = 10000;
    public static int HTTP_READ_TIMEOUT = 300000;
    private static RestTemplate restTemplate;

    private static RestTemplate configResttemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(HTTP_CONNECT_TIMEOUT);
        requestFactory.setReadTimeout(HTTP_READ_TIMEOUT);
        requestFactory.setBufferRequestBody(true);

        restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

    public static String postRequest(String url, Object requestObject, Credentials credentials) {
        restTemplate = configResttemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

        String jsonRequest = JsonUtil.toJson(requestObject);

        List<MediaType> acceptableTypes = new ArrayList<>();
        acceptableTypes.add(MediaType.APPLICATION_JSON);
        acceptableTypes.add(MediaType.TEXT_PLAIN);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.setAccept(acceptableTypes);

        String apiKey = credentials.getApiKey();
        String apiToken = credentials.getApiToken();
        String merchantId = credentials.getMerchantId();
        String requestId = credentials.getRequestId();
        String requesthash = SimpleSHAHashGenerator.generateSHA512SecurePassword(String.format("%s%s%s", apiKey, requestId, apiToken));

        DateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        timestamp.setTimeZone(TimeZone.getTimeZone("UTC"));
        headers.add("MERCHANT_ID", merchantId);
        headers.add("API_KEY", apiKey);
        headers.add("REQUEST_ID", requestId);
        headers.add("REQUEST_TS", timestamp.format(new Date()));
        headers.add("API_DETAILS_HASH", requesthash);
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequest, headers);

        Log.v("+++url ", url);
        Log.v("", "\n");
        Log.v("+++ Request Encrypted", jsonRequest);
        Log.v("", "\n");
        Log.v("+++ requestEntity: ", JsonUtil.toJson(requestEntity));
        Log.v("", "\n");

        ResponseEntity<String> responseEntity = null;
        try {
            Log.i(AbstractRestClient.class.getName(), url);

            responseEntity = restTemplate.postForEntity(url, requestEntity, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseEntity.getBody().toString();
    }
}
