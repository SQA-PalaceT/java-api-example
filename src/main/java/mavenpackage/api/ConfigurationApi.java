package mavenpackage.api;

import java.util.Properties;

public class ConfigurationApi {
    private static String URL = "https://9d86c5ae-13fc-409c-8c6d-32de9a755e0f.mock.pstmn.io"; //2021-11-10/2022-01-11/ZMSU
    private static String ContentType = "application/json; charset=UTF-8";
    private static String XRequestedWith = "XMLHttpRequest";

    Properties headers = new Properties();

    public static String getUrl() {
        return URL;
    }
    public static String getContentType() {
        return ContentType;
    }
    public static String getXRequestedWith() {
        return XRequestedWith;
    }

}