/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author cyc
 */
public class Visitor {
    
    private Map<Integer, String> identity = new HashMap<Integer, String>();
    
    private List<String> studentLikes = new ArrayList<String>();
    private List<String> professorLikes = new ArrayList<String>();
    private List<String> businessPersonLikes = new ArrayList<String>();
    private List<String> bloggerLikes = new ArrayList<String>();
    private Map<String,List<String>> visitorPref = new HashMap<String,List<String>>();
    
    public Visitor(){
        
        identity.put(0, "Student");
        identity.put(1, "Professor");
        identity.put(2, "Business Person");
        identity.put(3, "Blogger");
        
        studentLikes.add("Squirrel Hill");
        studentLikes.add("Downtown");
        studentLikes.add("The Point");
        
        businessPersonLikes.add("Squirrel Hill");
        businessPersonLikes.add("Downtown");
        
        professorLikes.add("Squirrel Hill");
        professorLikes.add("Downtown");
        professorLikes.add("The Point");
        professorLikes.add("The Cathedral of Learning");
        
        visitorPref.put("Student", studentLikes);
        visitorPref.put("Business Person", businessPersonLikes);
        visitorPref.put("Professor", professorLikes);
        visitorPref.put("Blogger", bloggerLikes);
    }
    
    public String getVisitor(int n){
        return identity.get(n);
    }
    
    public List<String> getVisitorsPref(String visitor){
        return visitorPref.get(visitor);
    }
}
