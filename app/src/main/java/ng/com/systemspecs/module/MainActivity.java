package ng.com.systemspecs.module;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.remita.paymentsdk.R;

import ng.com.systemspecs.config.Credentials;
import ng.com.systemspecs.config.RemitaRITSService;
import ng.com.systemspecs.dto.SinglePaymentRequest;
import ng.com.systemspecs.dto.SinglePaymentResponse;
import ng.com.systemspecs.utils.JsonUtil;
import ng.com.systemspecs.utils.StringUtils;

public class MainActivity extends AppCompatActivity {

    Button button;
    RemitaRITSService ritsService;
    SinglePaymentResponse singlePaymentResponse = null;
    SinglePaymentRequest request = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remita_activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Credentials credentials = new Credentials();
                    credentials.setEnvironment("DEMO");
                    credentials.setRequestId(System.currentTimeMillis() + StringUtils.EMPTY);
                    credentials.setMerchantId("DEMOMDA1234");
                    credentials.setApiKey("REVNT01EQTEyMzR8REVNT01EQQ==");
                    credentials.setApiToken("bmR1ZFFFWEx5R2c2NmhnMEk5a25WenJaZWZwbHFFYldKOGY0bHlGZnBZQ1N5WEpXU2Y1dGt3PT0=");
                    credentials.setSecretKey("nbzjfdiehurgsxct");
                    credentials.setSecretKeyIv("sngtmqpfurxdbkwj");

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
        });
    }

}
