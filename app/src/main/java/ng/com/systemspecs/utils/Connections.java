//package ng.com.systemspecs.utils;
//
//
//import ng.com.systemspecs.config.ApplicationUrl;
//import ng.com.systemspecs.config.Credentials;
//import org.springframework.http.*;
//import org.springframework.web.client.RestTemplate;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.TimeZone;
//
//public class Connections {
//
//    private static DateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
//
//    public static ResponseEntity<String> sendPostRequest(Credentials credentials, RestTemplate restTemplate, Object object, String url){
//        HttpHeaders headers = new HttpHeaders();
//        String apiKey = credentials.getApiKey();
//        String apiToken = credentials.getApiToken();
//        String merchantId = credentials.getMerchantId();
//        String requestId = credentials.getRequestId();
//        String requesthash = SimpleSHAHashGenerator.generateSHA512SecurePassword(String.format("%s%s%s", apiKey, requestId, apiToken));
//        timestamp.setTimeZone(TimeZone.getTimeZone("UTC"));
//        headers.add("MERCHANT_ID", merchantId);
//        headers.add("API_KEY", apiKey);
//        headers.add("REQUEST_ID", requestId);
//        headers.add("REQUEST_TS", timestamp.format(new Date()));
//        headers.add("API_DETAILS_HASH", requesthash);
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity httpEntity = new HttpEntity(object, headers);
//        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
//        return responseEntity;
//    }
//
//}
