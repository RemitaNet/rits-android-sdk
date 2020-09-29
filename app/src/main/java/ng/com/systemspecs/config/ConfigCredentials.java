package ng.com.systemspecs.config;

public class ConfigCredentials {


    public static String emptyCredentialsResponseCode;
    public static String emptyCredentialsMessage;
    public static String credentialStatus = "fail";

    public static boolean isCredential(Credentials credentials) {
        if (credentials.getApiKey() == null) {
            emptyCredentialsMessage = "key not available";
            emptyCredentialsResponseCode = "012";
            return false;

        } else if (credentials.getApiToken() == null) {
            emptyCredentialsMessage = "key not available";
            emptyCredentialsResponseCode = "013";
            return false;

        } else if (credentials.getMerchantId() == null) {
            emptyCredentialsMessage = "key not available";
            emptyCredentialsResponseCode = "011";
            return false;
        } else if (credentials.getSecretKey() == null) {
            emptyCredentialsMessage = "key not available";
            emptyCredentialsResponseCode = "014";
            return false;
        } else if (credentials.getSecretKey() == null) {
            emptyCredentialsMessage = "key not available";
            emptyCredentialsResponseCode = "014";
            return false;
        }
        return true;
    }

}
