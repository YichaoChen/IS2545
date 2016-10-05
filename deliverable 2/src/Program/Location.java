/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author cyc
 */
public class Location {
    
    // Use to store the locations in the game
    private List<String> loc = new ArrayList<String>();
    
    // In order to enable visitors to leave the city, I give the leaving option 
    // by putting it as a specail "place" in the map
    public Location(){
        loc.add("Left the city");
        loc.add("The Cathedral of Learning");
        loc.add("Squirrel Hill");
        loc.add("The point");
        loc.add("Downtown");
    }
    
    // Use to get the location
    public String getLocation(int n) {
		return loc.get(n);
    }
    
}
