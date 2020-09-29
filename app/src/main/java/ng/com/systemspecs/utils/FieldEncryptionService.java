package ng.com.systemspecs.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import ng.com.systemspecs.config.ApplicationUrl;
import ng.com.systemspecs.config.Credentials;
import ng.com.systemspecs.dto.SinglePaymentRequest;


public class FieldEncryptionService {

    private static String encoding = "UTF-8";


    static String encrypt(String plainText, String initVector, String secretKey, String algorithm, String cipherString, String encoding) {
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

}
