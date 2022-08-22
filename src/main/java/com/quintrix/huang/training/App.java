package com.quintrix.huang.training;
import java.util.HashMap;
import java.time.LocalTime;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        // lets do a lambda here
        System.out.println("Lets do some lambda!");
        // with a map
        HashMap<String, String> locations = new HashMap<String, String>();
		locations.put("Thanalan", "Ul'Dah");
		locations.put("Black Shroud", "Gridania");
		locations.put("La Noscea", "Limsa Lominsa");
        locations.forEach((key, value) -> {
        	System.out.println(value + " is in " + key);
        });
		
		// a stream here
        
        // some fucking with the time space continuum here
    }
}
