package ng.com.systemspecs.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ng.com.systemspecs.R;
import ng.com.systemspecs.config.Credentials;
import ng.com.systemspecs.dto.accountenquiry.AccountEnquiryRequest;
import ng.com.systemspecs.dto.accountenquiry.AccountEnquiryResponse;
import ng.com.systemspecs.dto.activebanks.GetActiveBankResponse;
import ng.com.systemspecs.dto.bulkpayment.BulkPaymentInfo;
import ng.com.systemspecs.dto.bulkpayment.BulkPaymentRequest;
import ng.com.systemspecs.dto.bulkpayment.BulkPaymentResponse;
import ng.com.systemspecs.dto.bulkpayment.PaymentDetails;
import ng.com.systemspecs.dto.bulkpayment.status.BulkPaymentStatusRequest;
import ng.com.systemspecs.dto.bulkpayment.status.BulkPaymentStatusResponse;
import ng.com.systemspecs.dto.singlepayment.SinglePaymentRequest;
import ng.com.systemspecs.dto.singlepayment.SinglePaymentResponse;
import ng.com.systemspecs.dto.singlepayment.status.PaymentStatusRequest;
import ng.com.systemspecs.dto.singlepayment.status.PaymentStatusResponse;
import ng.com.systemspecs.service.RemitaRITSService;
import ng.com.systemspecs.utils.JsonUtil;
import ng.com.systemspecs.utils.StringUtils;

public class MainActivity extends AppCompatActivity {

    Credentials credentials;
    RemitaRITSService ritsService;
    SinglePaymentRequest request = null;
    SinglePaymentResponse singlePaymentResponse = null;
    PaymentStatusRequest singlePaymentStatusRequest = null;
    PaymentStatusResponse singlePaymentStatusResponse = null;
    GetActiveBankResponse getActiveBankResponse = null;
    AccountEnquiryRequest accountEnquiryRequest = null;
    AccountEnquiryResponse accountEnquiryResponse = null;
    BulkPaymentRequest bulkPaymentRequest = null;
    BulkPaymentResponse bulkPaymentResponse = null;
    BulkPaymentStatusRequest bulkPaymentStatusRequest = null;
    BulkPaymentStatusResponse bulkPaymentStatusResponse = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remita_activity_main);

        credentials = new Credentials();
        credentials.setEnvironment("DEMO");
        credentials.setRequestId(System.currentTimeMillis() + StringUtils.EMPTY);
        credentials.setMerchantId("DEMOMDA1234");
        credentials.setApiKey("REVNT01EQTEyMzR8REVNT01EQQ==");
        credentials.setApiToken("bmR1ZFFFWEx5R2c2NmhnMEk5a25WenJaZWZwbHFFYldKOGY0bHlGZnBZQ1N5WEpXU2Y1dGt3PT0=");
        credentials.setSecretKey("nbzjfdiehurgsxct");
        credentials.setSecretKeyIv("sngtmqpfurxdbkwj");
    }

    public void activeBanks(View view) {
        ritsService = new RemitaRITSService(credentials);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getActiveBankResponse = ritsService.activeBanks();
                    Log.v("+++ Response: ", JsonUtil.toJson(getActiveBankResponse));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void accountEnquiry(View view) {
        try {
            ritsService = new RemitaRITSService(credentials);
            accountEnquiryRequest = new AccountEnquiryRequest();
            accountEnquiryRequest.setAccountNo("4589999044");
            accountEnquiryRequest.setBankCode("044");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        accountEnquiryResponse = ritsService.accountEnquiryRequest(accountEnquiryRequest);
                        Log.v("+++ Response: ", JsonUtil.toJson(accountEnquiryResponse));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void singlePayment(View view) {
        try {
            ritsService = new RemitaRITSService(credentials);
            request = new SinglePaymentRequest();
            request.setFromBank("058");
            request.setDebitAccount("8909090989");
            request.setToBank("044");
            request.setCreditAccount("4589999044");
            request.setNarration("Regular Payment");
            request.setAmount("1500");
            request.setBeneficiaryEmail("qa@test.com");
            request.setTransRef(System.currentTimeMillis() + StringUtils.EMPTY);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        singlePaymentResponse = ritsService.singlePayment(request);
                        Log.v("+++ Response: ", JsonUtil.toJson(singlePaymentResponse));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void singlePaymentStatus(View view) {
        try {
            ritsService = new RemitaRITSService(credentials);
            singlePaymentStatusRequest = new PaymentStatusRequest();
            singlePaymentStatusRequest.setTransRef("1601394812513");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        singlePaymentStatusResponse = ritsService.singlePaymentStatus(singlePaymentStatusRequest);
                        Log.v("+++ Response: ", JsonUtil.toJson(singlePaymentResponse));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bulkPayment(View view) {
        try {
            ritsService = new RemitaRITSService(credentials);
            bulkPaymentRequest = new BulkPaymentRequest();

            BulkPaymentInfo bulkPaymentInfo = new BulkPaymentInfo();
            bulkPaymentInfo.setTotalAmount("20000");
            bulkPaymentInfo.setBatchRef(System.currentTimeMillis() + StringUtils.EMPTY);
            bulkPaymentInfo.setDebitAccount("1234565678");
            bulkPaymentInfo.setBankCode("044");
            bulkPaymentInfo.setNarration("Regular Payment");

            List<PaymentDetails> listPaymentDetails = new ArrayList<>();
            PaymentDetails paymentDetails = new PaymentDetails();
            paymentDetails.setAmount("8000");
            paymentDetails.setBenficiaryEmail("qa@test.com");
            paymentDetails.setTransRef(System.currentTimeMillis() + StringUtils.EMPTY);
            paymentDetails.setBenficiaryBankCode("058");
            paymentDetails.setBenficiaryAccountNumber("0582915208011");
            paymentDetails.setNarration("Regular Payment");

            PaymentDetails paymentDetailsOne = new PaymentDetails();
            paymentDetailsOne.setAmount("8000");
            paymentDetailsOne.setBenficiaryEmail("qa@test.com");
            paymentDetailsOne.setTransRef(System.currentTimeMillis() + StringUtils.EMPTY);
            paymentDetailsOne.setBenficiaryBankCode("058");
            paymentDetailsOne.setBenficiaryAccountNumber("0582915208012");
            paymentDetailsOne.setNarration("Regular Payment");

            PaymentDetails paymentDetailsTwo = new PaymentDetails();
            paymentDetailsTwo.setAmount("4000");
            paymentDetailsTwo.setBenficiaryEmail("qa@test.com");
            paymentDetailsTwo.setTransRef(System.currentTimeMillis() + StringUtils.EMPTY);
            paymentDetailsTwo.setBenficiaryBankCode("058");
            paymentDetailsTwo.setBenficiaryAccountNumber("0582915208013");
            paymentDetailsTwo.setNarration("Regular Payment");
            listPaymentDetails.add(paymentDetails);
            listPaymentDetails.add(paymentDetailsOne);
            listPaymentDetails.add(paymentDetailsTwo);

            bulkPaymentRequest.setPaymentDetails(listPaymentDetails);
            bulkPaymentRequest.setBulkPaymentInfo(bulkPaymentInfo);
            bulkPaymentResponse = ritsService.bulkPayment(bulkPaymentRequest);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        bulkPaymentResponse = ritsService.bulkPayment(bulkPaymentRequest);
                        Log.v("+++ Response: ", JsonUtil.toJson(bulkPaymentResponse));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bulkPaymentStatus(View view) {
        try {
            ritsService = new RemitaRITSService(credentials);
            bulkPaymentStatusRequest = new BulkPaymentStatusRequest();
            bulkPaymentStatusRequest.setBatchRef("1601394812513");
            bulkPaymentStatusRequest.setTransRef("285755");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        bulkPaymentStatusResponse = ritsService.bulkPaymentStatus(bulkPaymentStatusRequest);
                        Log.v("+++ Response: ", JsonUtil.toJson(bulkPaymentStatusResponse));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
