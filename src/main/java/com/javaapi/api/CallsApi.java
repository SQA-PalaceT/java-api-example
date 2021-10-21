package mavenpackage.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CallsApi {
    
    public static String getAPI(String endpoint){
        try {
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(ConfigurationApi.getUrl() + "/" + endpoint))
            .GET()
            .build();
            return handleRequest(request);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }
    /**
     * The handler method takes an event and context object as input and returns a string
     */
    private static String handleRequest(HttpRequest request){

        try {
            CompletableFuture<HttpResponse<String>> response = HttpClient.newBuilder()
            .build()
            .sendAsync(request, BodyHandlers.ofString());
            
            return response.get().body();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
