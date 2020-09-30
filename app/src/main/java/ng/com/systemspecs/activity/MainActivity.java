package ng.com.systemspecs.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import ng.com.systemspecs.R;
import ng.com.systemspecs.config.Credentials;
import ng.com.systemspecs.dto.activebanks.GetActiveBankResponse;
import ng.com.systemspecs.dto.singlepayment.status.PaymentStatusRequest;
import ng.com.systemspecs.dto.singlepayment.status.PaymentStatusResponse;
import ng.com.systemspecs.service.RemitaRITSService;
import ng.com.systemspecs.dto.singlepayment.SinglePaymentRequest;
import ng.com.systemspecs.dto.singlepayment.SinglePaymentResponse;
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
}
