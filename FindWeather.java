/*
 * https://www.weatherapi.com/docs/
 * This api gets weather info from everyhwere
 */
import com.google.gson.Gson;
import java.net.*;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
public class FindWeather {
    // return data from weather.com as a string. Input is the city/zipcode user inputs.
    String printout(String input) throws Exception{
        weather poo = new weather();
        // create weather object to get the data from weather API
        HttpRequest getRequest = HttpRequest.newBuilder() //request info from api
        .uri(new URI("http://api.weatherapi.com/v1/current.json?key=1cc50b263dd54daa8d6171130231807&q=" + input))
        .GET()
        .build();
    
    HttpClient httpClient = HttpClient.newHttpClient();
    
    HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString()); //response from API
    
    //System.out.println(getResponse.body());
    
    poo = new Gson().fromJson(getResponse.body(), weather.class);
    // parse the json data from the Response
    return "Location: " + poo.location.name + " Temperature: " + poo.current.temp_f + "  Weather: " + poo.current.condition.text ;
    }
}
