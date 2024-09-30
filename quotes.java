/*
 * https://api.quotable.io/random
 * This api gives random quotes from famous people
 */
import com.google.gson.Gson;
import java.net.*;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class quotes {
    //returns random quote and author from api.quotable as a string
    String printout() throws Exception{
        weather poo = new weather();
        Gson gson = new Gson();
        HttpRequest getRequest = HttpRequest.newBuilder()
            .uri(new URI("https://api.quotable.io/random"))
            .GET()
            .build();
        
        HttpClient httpClient = HttpClient.newHttpClient();
        
        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        
        poo = gson.fromJson(getResponse.body(), weather.class);
        //parse the json data from the Response
        
        return "Quote: " + poo.content + " Author: " + poo.author;
    }         
}