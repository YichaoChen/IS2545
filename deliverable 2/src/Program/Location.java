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
    
    private List<String> loc = new ArrayList<String>();
    
    public Location(){
        loc.add("Left the city");
        loc.add("The Cathedral of Learning");
        loc.add("Squirrel Hill");
        loc.add("The point");
        loc.add("Downtown");
    }
     
    public String getLocation(int n) {
		return loc.get(n);
    }
    
}
