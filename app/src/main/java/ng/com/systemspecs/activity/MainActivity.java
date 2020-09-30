package ng.com.systemspecs.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.remita.paymentsdk.R;

import ng.com.systemspecs.config.Credentials;
import ng.com.systemspecs.service.RemitaRITSService;
import ng.com.systemspecs.dto.singlepayment.SinglePaymentRequest;
import ng.com.systemspecs.dto.singlepayment.SinglePaymentResponse;
import ng.com.systemspecs.utils.JsonUtil;
import ng.com.systemspecs.utils.StringUtils;

public class MainActivity extends AppCompatActivity {

    RemitaRITSService ritsService;
    SinglePaymentResponse singlePaymentResponse = null;
    SinglePaymentRequest request = null;
    Credentials credentials;

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
}
