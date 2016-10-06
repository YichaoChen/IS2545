/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cyc
 */
public class Visitor {
    
    // Use to store four types of visitors
    private Map<Integer, String> identity = new HashMap<Integer, String>();
    
    // Use to store each visitor's prefer places
    private List<String> studentLikes = new ArrayList<String>();
    private List<String> professorLikes = new ArrayList<String>();
    private List<String> businessPersonLikes = new ArrayList<String>();
    private List<String> bloggerLikes = new ArrayList<String>();
    
    // Connect the visitors and their prefer places, just like a table joint
    private Map<String,List<String>> visitorPref = new HashMap<String,List<String>>();
    
    public Visitor(){
        
        // Put visitors in
        identity.put(0, "Student");
        identity.put(1, "Professor");
        identity.put(2, "Business Person");
        identity.put(3, "Blogger");
        
        // Put their preference in
        studentLikes.add("Squirrel Hill");
        studentLikes.add("Downtown");
        studentLikes.add("The Point");
        
        businessPersonLikes.add("Squirrel Hill");
        businessPersonLikes.add("Downtown");
        
        professorLikes.add("Squirrel Hill");
        professorLikes.add("Downtown");
        professorLikes.add("The Point");
        professorLikes.add("The Cathedral of Learning");
        
        // Connnect them together
        visitorPref.put("Student", studentLikes);
        visitorPref.put("Business Person", businessPersonLikes);
        visitorPref.put("Professor", professorLikes);
        visitorPref.put("Blogger", bloggerLikes);
    }
    
    // Use to get the visitor's type
    public String getVisitor(int n){
        return identity.get(n);
    }
    
    // Use to get the visitor's prefer places
    public List<String> getVisitorsPref(String visitor){
        return visitorPref.get(visitor);
    }
}
