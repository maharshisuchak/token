package com.smartsensesolutions.token.config;


public class ConfigCommonStrings {

    public static String strDummyTransactionJSON = "{\n" +
            "  \"transactions\": [\n" +
            "    {\n" +
            "      \"transaction_id\": \"1\",\n" +
            "      \"transaction_date\": \"Jul 13, 2017\",\n" +
            "      \"transaction_details\": [\n" +
            "        {\n" +
            "          \"transaction_title\": \"Receive Money\",\n" +
            "          \"transaction_type\": \"receive\",\n" +
            "          \"transaction_amount\": \"+$750.25(unconfirmed)\",\n" +
            "          \"transaction_extra\": \"From a bitcoin address\",\n" +
            "          \"transaction_bitcoion\": \"1.2083 Bitcoin\",\n" +
            "          \"transaction_status\": \"unconfirmed\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"transaction_id\": \"2\",\n" +
            "      \"transaction_date\": \"Jul 11, 2017\",\n" +
            "      \"transaction_details\": [\n" +
            "        {\n" +
            "          \"transaction_title\": \"Sent Money\",\n" +
            "          \"transaction_type\": \"sent\",\n" +
            "          \"transaction_amount\": \"-$122.25\",\n" +
            "          \"transaction_extra\": \"From a bitcoin address\",\n" +
            "          \"transaction_bitcoion\": \"1.2083 Bitcoin\",\n" +
            "          \"transaction_status\": \"minus\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"transaction_title\": \"Transfered Money\",\n" +
            "          \"transaction_type\": \"transferred\",\n" +
            "          \"transaction_amount\": \"$335.37\",\n" +
            "          \"transaction_extra\": \"into Bitcoin Savings\",\n" +
            "          \"transaction_bitcoion\": \"1.2083 Bitcoin\",\n" +
            "          \"transaction_status\": \"normal\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"transaction_id\": \"3\",\n" +
            "      \"transaction_date\": \"Jul 10, 2017\",\n" +
            "      \"transaction_details\": [\n" +
            "        {\n" +
            "          \"transaction_title\": \"Withdraw Money\",\n" +
            "          \"transaction_type\": \"withdraw\",\n" +
            "          \"transaction_amount\": \"-750.25\",\n" +
            "          \"transaction_extra\": \"From a bitcoin address\",\n" +
            "          \"transaction_bitcoion\": \"1.2083 Bitcoin\",\n" +
            "          \"transaction_status\": \"minus\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"transaction_title\": \"Deposited Money\",\n" +
            "          \"transaction_type\": \"deposit\",\n" +
            "          \"transaction_amount\": \"+$335.37\",\n" +
            "          \"transaction_extra\": \"into Bitcoin Savings\",\n" +
            "          \"transaction_bitcoion\": \"1.2083 Bitcoin\",\n" +
            "          \"transaction_status\": \"plus\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"transaction_title\": \"Received Money\",\n" +
            "          \"transaction_type\": \"receive\",\n" +
            "          \"transaction_amount\": \"+$335.37\",\n" +
            "          \"transaction_extra\": \"into Bitcoin Savings\",\n" +
            "          \"transaction_bitcoion\": \"1.2083 Bitcoin\",\n" +
            "          \"transaction_status\": \"plus\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";


    public static String TT_RECEIVE = "receive";
    public static String TT_SENT = "sent";
    public static String TT_TRANSFERRED = "transferred";
    public static String TT_WITHDRAW = "withdraw";
    public static String TT_DEPOSIT = "deposit";

    public static String TS_UNCONFIRMED = "unconfirmed";
    public static String TS_MINUS = "minus";
    public static String TS_NORMAL = "normal";
    public static String TS_PLUS = "plus";

    public static String DATE_FORMAT = "MMM dd, yyyy";

    public static String KEY_INTENT_FROM_TOKEN_SENDING = "key_from_token_sending";
    public static String VALUE_INTENT_FROM_TOKEN_SENDING = "value_from_token_sending";
}
