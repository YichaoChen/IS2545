/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Domain.Validator;

/**
 *
 * @author AsphaltPanthers
 */
public class CitySim9002 {
    public static String errorMessage = "Please enter one integer argument, seed";
    public static int seed;
    
    public static void main(String[] args) {
          // Validate the input arguments
          if (new Validator().validateArguments(args)) {
                seed = Integer.parseInt(args[0]); // If the argument number is 1 and it
          }else {                                 // is an integer, pass the validation
                System.out.println(errorMessage); // Else exit the program
                System.exit(0);
          }
          
          int visitorNumber = 5; // There will be five visitors.
          int visitorType = 4; // Four types: Student, Professor, Business Person, Blogger.
          int locationNumber = 5; // Including the way leaving the city.
          String visitor = "";
          String location = "";
          
          RandomGenerator visitorGenerator = new RandomGenerator(seed,visitorType); // For randomly choose visitors
          RandomGenerator locationGenerator = new RandomGenerator(seed,locationNumber); // For randomly choose locations
          
          Visitor visitors = new Visitor();
          Location locations = new Location();
          
          System.out.println("Welcome to CitySim! Your seed is " + seed);
          
          // Loop to generate five visitors according to the requirements
          for(int i = 0; i < visitorNumber; i++){
              // Randomly pick up a visitor
              visitor = visitors.getVisitor(visitorGenerator.generate()); 
              System.out.println("Visitor " + (i + 1) + " is a " + visitor);
              
              // Randomly pick up a location
              location = locations.getLocation(locationGenerator.generate()); 
              
              // Cannot leave the city at the first visit
              while(location == "Left the city"){ 
                  location = locations.getLocation(locationGenerator.generate());
              }
              
              // Continue visiting until the visitor wants to leave
              while(location != "Left the city"){ 
                  System.out.println("Visitor " + (i + 1) + " is going to " + location);
                  
                  // Look up whether the visitor likes this location
                  if(visitors.getVisitorsPref(visitor).contains(location)){
                      System.out.println("Visitor " + (i + 1) + " did like " + location);
                  } else {
                      System.out.println("Visitor " + (i + 1) + " did not like " + location);
                  }
                  location = locations.getLocation(locationGenerator.generate());
              }
              
              System.out.println("Visitor " + (i + 1) + " has left the city.");
              System.out.println("***");
          }
    }
    
}
