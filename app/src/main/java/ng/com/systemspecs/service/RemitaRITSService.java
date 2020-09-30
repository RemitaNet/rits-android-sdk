package ng.com.systemspecs.service;

import android.util.Log;

import com.google.gson.Gson;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ng.com.systemspecs.config.ApplicationUrl;
import ng.com.systemspecs.config.ConfigCredentials;
import ng.com.systemspecs.config.Credentials;
import ng.com.systemspecs.dto.accountenquiry.AccountEnquiry;
import ng.com.systemspecs.dto.accountenquiry.AccountEnquiryRequest;
import ng.com.systemspecs.dto.accountenquiry.AccountEnquiryResponse;
import ng.com.systemspecs.dto.activebanks.Banks;
import ng.com.systemspecs.dto.activebanks.GetActiveBank;
import ng.com.systemspecs.dto.activebanks.GetActiveBankResponse;
import ng.com.systemspecs.dto.bulkpayment.BulkPayment;
import ng.com.systemspecs.dto.bulkpayment.BulkPaymentRequest;
import ng.com.systemspecs.dto.bulkpayment.BulkPaymentResponse;
import ng.com.systemspecs.dto.bulkpayment.status.BulkPaymentStatus;
import ng.com.systemspecs.dto.bulkpayment.status.BulkPaymentStatusInfo;
import ng.com.systemspecs.dto.bulkpayment.status.BulkPaymentStatusRequest;
import ng.com.systemspecs.dto.bulkpayment.status.BulkPaymentStatusResponse;
import ng.com.systemspecs.dto.singlepayment.SinglePayment;
import ng.com.systemspecs.dto.singlepayment.SinglePaymentRequest;
import ng.com.systemspecs.dto.singlepayment.SinglePaymentResponse;
import ng.com.systemspecs.dto.singlepayment.status.PaymentStatus;
import ng.com.systemspecs.dto.singlepayment.status.PaymentStatusRequest;
import ng.com.systemspecs.dto.singlepayment.status.PaymentStatusResponse;
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

    public GetActiveBankResponse activeBanks() throws Exception {
        GetActiveBankResponse getActiveBankResponse = null;
        String url = null;
        if (!ConfigCredentials.isCredential(credentials)) {
            GetActiveBank data = new GetActiveBank();
            GetActiveBankResponse response = new GetActiveBankResponse();
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
        url = url + ApplicationUrl.ACTIVE_BANKS;

        String response = null;

        response = AbstractRestClient.postRequest(url, null, credentials);
        getActiveBankResponse = JsonUtil.fromJson(response, GetActiveBankResponse.class);

        return getActiveBankResponse;
    }

    public AccountEnquiryResponse accountEnquiryRequest(AccountEnquiryRequest request) throws Exception {
        AccountEnquiryResponse accountEnquiryResponse = null;
        String url = null;
        if (!ConfigCredentials.isCredential(credentials)) {
            AccountEnquiry data = new AccountEnquiry();
            AccountEnquiryResponse response = new AccountEnquiryResponse();
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
        url = url + ApplicationUrl.ACCOUNT_ENQUIRY;

        Log.v("+++ Request ", JsonUtil.toJson(request));
        Log.v("", "");

        request.setAccountNo(FieldEncryptionService.encryptField(request.getAccountNo().trim(), credentials));
        request.setBankCode(FieldEncryptionService.encryptField(request.getBankCode().trim(), credentials));

        String response = null;

        response = AbstractRestClient.postRequest(url, request, credentials);
        accountEnquiryResponse = JsonUtil.fromJson(response, AccountEnquiryResponse.class);

        return accountEnquiryResponse;
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
        Log.v("", "");

        request = FieldEncryptionService.encryptSinglePaymentFields(request, credentials);

        SinglePaymentResponse singlePaymentResponse = null;
        String response = null;

        response = AbstractRestClient.postRequest(url, request, credentials);
        singlePaymentResponse = JsonUtil.fromJson(response, SinglePaymentResponse.class);


        return singlePaymentResponse;
    }

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
        url = url + ApplicationUrl.SINGLE_PAYMENT_STATUS;

        Log.v("+++ Request ", JsonUtil.toJson(request));
        Log.v("", "");

        request = FieldEncryptionService.encryptSinglePaymentStatusField(request, credentials);

        String response = null;

        response = AbstractRestClient.postRequest(url, request, credentials);
        paymentStatusResponse = JsonUtil.fromJson(response, PaymentStatusResponse.class);

        return paymentStatusResponse;
    }

    public BulkPaymentResponse bulkPayment(BulkPaymentRequest request) throws Exception {
        String url = null;
        if (!ConfigCredentials.isCredential(credentials)) {
            BulkPayment data = new BulkPayment();
            BulkPaymentResponse response = new BulkPaymentResponse();
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
        url = url + ApplicationUrl.BULK_PAYMENT;

        Log.v("+++ Request ", JsonUtil.toJson(request));
        Log.v("", "");

        request = FieldEncryptionService.encryptBulkPaymentFields(request, credentials);
        String response = null;
        response = AbstractRestClient.postRequest(url, request, credentials);

        return JsonUtil.fromJson(response, BulkPaymentResponse.class);
    }

    public BulkPaymentStatusResponse bulkPaymentStatus(BulkPaymentStatusRequest request) throws Exception {
        String url = null;
        if (!ConfigCredentials.isCredential(credentials)) {
            BulkPaymentStatus data = new BulkPaymentStatus();
            BulkPaymentStatusInfo bulkPaymentStatusInfo = new BulkPaymentStatusInfo();
            BulkPaymentStatusResponse response = new BulkPaymentStatusResponse();
            bulkPaymentStatusInfo.setResponseCode(ConfigCredentials.emptyCredentialsResponseCode);
            bulkPaymentStatusInfo.setResponseMessage(ConfigCredentials.emptyCredentialsMessage);
            data.setBulkPaymentStatusInfo(bulkPaymentStatusInfo);
            response.setData(data);
            response.setStatus(ConfigCredentials.credentialStatus);
            return response;
        }
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
            url = ApplicationUrl.LIVE;
        } else {
            url = ApplicationUrl.DEMO;
        }
        url = url + ApplicationUrl.BULK_PAYMENT_STATUS;

        Log.v("+++ Request ", JsonUtil.toJson(request));
        Log.v("", "");

        request.setTransRef(FieldEncryptionService.encrypt(request.getTransRef().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, FieldEncryptionService.encoding));
        request.setBatchRef(FieldEncryptionService.encrypt(request.getBatchRef().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, FieldEncryptionService.encoding));
        String response = null;

        response = AbstractRestClient.postRequest(url, request, credentials);

        return JsonUtil.fromJson(response, BulkPaymentStatusResponse.class);

    }

    public RestTemplate commonsRestTemplate(Credentials credentials) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(credentials.getConnectionTimeOut());
        factory.setReadTimeout(credentials.getReadTimeOut());
        return new RestTemplate(factory);
    }
}
