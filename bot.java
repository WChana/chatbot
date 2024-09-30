import org.jibble.pircbot.*;
//extend the main pircbot class - This can only be done AFTER you import the jar file 
//This class is the main logic of your pircbot, this is where you will implement any functionality 
public class bot extends PircBot
{
    quotes quote = new quotes();
    //String q;
    FindWeather obj = new FindWeather();
    //String w;
//constructor 
	public bot(){
       		this.setName("myWeatherBot"); //this is the name the bot will use to join the IRC server
   	}
//every time a message is sent, this method will be called and this information will be passed on
//this is how you read a message from the channel 
public void onMessage(String channel, String sender, String login, String hostname, String message) {
        // Use this function to read the message that comes in 
        //For example, you can have an if statment that says:
        if (message.contains("weather")) { 
            // give instructions to get weather in a city they want
            sendMessage(channel, "Type \"Weather in \" then type a city or zipcode you want the weather of(capitalization matters)");
        } 
        if (message.contains("quote")) {
        //the user wants quote, so call the quotes API
            try {
                //q = quote.printout();
                sendMessage(channel, quote.printout());
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        }
        if (message.contains("Weather in ")) { 
            try {
                sendMessage(channel, obj.printout(message.substring(11))); 
                //get whatever string they input after "Weather in "
            } catch (Exception e) {
                
                e.printStackTrace();
            }
        }
        //or to start, do something small like:
        if (message.contains("Hello") || message.contains("Hi") || message.contains("hi") || message.contains("hello")) {
            //the user wants weather, so call the weather API you created in part 1
            //this is how you send a message back to the channel 
            sendMessage(channel, "Hey " + sender + "! ");
        }
        if (message.contains("poo")) {
            sendMessage(channel, "You're so funny"); //easter egg heehee
        }
        if (message.contains("bye")) {
            System.exit(0); //close program
        }
	}
}

