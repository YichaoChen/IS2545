/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

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
        loc.add("The Cathedral of Learning");
        loc.add("Squirrel Hill");
        loc.add("The point");
        loc.add("Downtown");
        loc.add("Left the city");
    }
    
    // Use to get the location
    public String getLocation(int n) {
		return loc.get(n);
    }
    
    // Use to judge whether the "first place" is to leave the city
    public boolean firstVisitLeft(String loc){
        if(loc == "Left the city"){
            return true;
        }
        return false;
    }
    
}
