package com.javaapi.api;

// import java.net.Authenticator;
// import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Calls {
    
    public static String get(String endpoint){

        try {
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(Config.getUrl() + "/" + endpoint))
            .GET()
            .build();

            
            return handleRequest(request);
        } catch (URISyntaxException  e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public static String post(String endpoint, String data){

        try {
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(Config.getUrl() + "/" + endpoint))
            .headers("Content-Type", Config.getContentType())
            .POST(HttpRequest.BodyPublishers.ofString(data))
            .build();

            
            return handleRequest(request);
        }catch(URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String put(String endpoint, String data){

        try {
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(Config.getUrl() + "/" + endpoint))
            .headers("Content-Type", Config.getContentType())
            .PUT(HttpRequest.BodyPublishers.ofString(data))
            .build();

            
            return handleRequest(request);
        }catch(URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String delete(String endpoint){

        try {
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(Config.getUrl() + "/" + endpoint))
            .DELETE()
            .build();

            
            return handleRequest(request);
        }catch(URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String handleRequest(HttpRequest request){

        try {
            CompletableFuture<HttpResponse<String>> response = HttpClient.newBuilder()

            /*** Can set authentication if needed. */
            /*.authenticator(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                    "username", 
                    "password".toCharArray());
                }
            })*/

            .build()
            .sendAsync(request, BodyHandlers.ofString());
            
            return response.get().body();
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}