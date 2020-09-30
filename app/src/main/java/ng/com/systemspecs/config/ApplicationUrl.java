package ng.com.systemspecs.config;

public class ApplicationUrl {

    public static String algorithm = "AES";

    public static String cipher = "AES/CBC/PKCS5PADDING";

    public static String ACTIVE_BANKS = "/fi/banks";

    public static String ACCOUNT_ENQUIRY = "/merc/fi/account/lookup";

    public static String SINGLE_PAYMENT = "/merc/payment/singlePayment.json";

    public static String SINGLE_PAYMENT_STATUS = "/merc/payment/status";

    public static String BULK_PAYMENT = "/merc/bulk/payment/send";

    public static String BULK_PAYMENT_STATUS = "/merc/bulk/payment/status";

    public final static String DEMO = "https://remitademo.net/remita/exapp/api/v1/send/api/rpgsvc/rpg/api/v2";

    public final static String LIVE = "https://login.remita.net/remita/exapp/api/v1/send/api/rpgsvc/rpg/api/v2";
}
