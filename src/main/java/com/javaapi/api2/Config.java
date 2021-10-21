package com.javaapi.api;

import java.util.Properties;

public class Config {

    private static String UserToken = "token";
    private static String URL = "https://jsonplaceholder.typicode.com";
    private static String ContentType = "application/json; charset=UTF-8";
    private static String XRequestedWith = "XMLHttpRequest";
    private static String Authorization = "Bearer " + UserToken;

    Properties headers = new Properties();

    public static String getUrl(){
        return URL;
    }

    public static String getContentType(){
        return ContentType;
    }

    public static String getXRequestedWith(){
        return XRequestedWith;
    }

    public static String getAuthorization(){
        return Authorization;
    }
}
