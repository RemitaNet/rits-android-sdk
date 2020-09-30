package ng.com.systemspecs.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import ng.com.systemspecs.config.ApplicationUrl;
import ng.com.systemspecs.config.Credentials;
import ng.com.systemspecs.dto.bulkpayment.BulkPaymentInfo;
import ng.com.systemspecs.dto.bulkpayment.BulkPaymentRequest;
import ng.com.systemspecs.dto.bulkpayment.PaymentDetails;
import ng.com.systemspecs.dto.singlepayment.SinglePaymentRequest;
import ng.com.systemspecs.dto.singlepayment.status.PaymentStatusRequest;


public class FieldEncryptionService {

    public static String encoding = "UTF-8";


    public static String encrypt(String plainText, String initVector, String secretKey, String algorithm, String cipherString, String encoding) {
        String encryptedText = StringUtils.EMPTY;
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(encoding));
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(encoding), algorithm);
            Cipher cipher = Cipher.getInstance(cipherString);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
            byte[] encrypted = cipher.doFinal(plainText.getBytes(encoding));
            encryptedText = new String(Base64.encodeBase64(encrypted), encoding);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return encryptedText;
    }

    public static SinglePaymentRequest encryptSinglePaymentFields(SinglePaymentRequest singlePaymentRequest, Credentials credentials) {
        SinglePaymentRequest encryptedSinglePaymentRequest = new SinglePaymentRequest();
        encryptedSinglePaymentRequest.setToBank(encrypt(singlePaymentRequest.getToBank().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedSinglePaymentRequest.setCreditAccount(encrypt(singlePaymentRequest.getCreditAccount().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedSinglePaymentRequest.setNarration(encrypt(singlePaymentRequest.getNarration(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedSinglePaymentRequest.setAmount(encrypt(singlePaymentRequest.getAmount().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedSinglePaymentRequest.setTransRef(encrypt(singlePaymentRequest.getTransRef().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedSinglePaymentRequest.setFromBank(encrypt(singlePaymentRequest.getFromBank().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedSinglePaymentRequest.setDebitAccount(encrypt(singlePaymentRequest.getDebitAccount().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedSinglePaymentRequest.setBeneficiaryEmail(encrypt(singlePaymentRequest.getBeneficiaryEmail().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));

        return encryptedSinglePaymentRequest;
    }

    public static PaymentStatusRequest encryptSinglePaymentStatusField(PaymentStatusRequest request, Credentials credentials) {
        PaymentStatusRequest encryptedRequest = new PaymentStatusRequest();
        encryptedRequest.setTransRef(encrypt(request.getTransRef().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        return encryptedRequest;
    }

    public static String encryptField(String field, Credentials credentials) {
        return encrypt(field.trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding);
    }

    public static BulkPaymentRequest encryptBulkPaymentFields(BulkPaymentRequest request, Credentials credentials) {

        BulkPaymentRequest bulkPaymentRequest = new BulkPaymentRequest();

        BulkPaymentInfo bulkPaymentInfo = request.getBulkPaymentInfo();
        BulkPaymentInfo encryptedBulkPaymentInfo = new BulkPaymentInfo();
        encryptedBulkPaymentInfo.setTotalAmount(encrypt(bulkPaymentInfo.getTotalAmount().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedBulkPaymentInfo.setBatchRef(encrypt(bulkPaymentInfo.getBatchRef().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedBulkPaymentInfo.setDebitAccount(encrypt(bulkPaymentInfo.getDebitAccount().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedBulkPaymentInfo.setBankCode(encrypt(bulkPaymentInfo.getBankCode().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
        encryptedBulkPaymentInfo.setNarration(encrypt(bulkPaymentInfo.getNarration().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));

        List<PaymentDetails> paymentDetailsList = request.getPaymentDetails();
        List<PaymentDetails> encryptedPaymentDetailsList = new ArrayList<>();
        PaymentDetails encryptedPaymentDetail;

        for (PaymentDetails paymentDetails : paymentDetailsList) {

            encryptedPaymentDetail = new PaymentDetails();
            encryptedPaymentDetail.setAmount(encrypt(paymentDetails.getAmount().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
            encryptedPaymentDetail.setBenficiaryEmail(encrypt(paymentDetails.getBenficiaryEmail().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
            encryptedPaymentDetail.setTransRef(encrypt(paymentDetails.getTransRef().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
            encryptedPaymentDetail.setBenficiaryBankCode(encrypt(paymentDetails.getBenficiaryBankCode().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
            encryptedPaymentDetail.setBenficiaryAccountNumber(encrypt(paymentDetails.getBenficiaryAccountNumber().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
            encryptedPaymentDetail.setNarration(encrypt(paymentDetails.getNarration().trim(), credentials.getSecretKeyIv(), credentials.getSecretKey(), ApplicationUrl.algorithm, ApplicationUrl.cipher, encoding));
            encryptedPaymentDetailsList.add(encryptedPaymentDetail);
        }

        bulkPaymentRequest.setBulkPaymentInfo(encryptedBulkPaymentInfo);
        bulkPaymentRequest.setPaymentDetails(encryptedPaymentDetailsList);

        return bulkPaymentRequest;
    }
}
