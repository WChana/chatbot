/*
 * weather class contains objects to match APIs
 */
public class weather {
    LocationObject location;

    CurrentObject current;

    String content;
    
    String author;

    class LocationObject {
        String name;
    }

    class CurrentObject {
        String temp_f;

        ConditionObject condition;
        
        class ConditionObject {
            String text;
        }
    }
    
}
