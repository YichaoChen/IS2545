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
    
    public static void main(String[] args) {
//        if (new Validator().validateArguments(args)) {
//            return 0;
//        }
//        else {
//            System.out.println(errorMessage);
//            return -1;
//        }

          int seed = 3;
          int visitorNumber = 5; // There will be five visitors.
          int visitorType = 4; // Four types: Student, Professor, Business Person, Blogger.
          int locationNumber = 5; // Including the way leaving the city.
          String visitor = "";
          String location = "";
          
          RandomGenerator visitorGenerator = new RandomGenerator(seed,visitorType);
          RandomGenerator locationGenerator = new RandomGenerator(seed,locationNumber);
          
          Visitor visitors = new Visitor();
          Location locations = new Location();
          
          System.out.println("Welcome to CitySim! Your seed is " + seed);
          
          for(int i = 0; i < visitorNumber; i++){
              visitor = visitors.getVisitor(visitorGenerator.generate());
              System.out.println("Visitor " + (i + 1) + " is a " + visitor);
              
              location = locations.getLocation(locationGenerator.generate());
              
              while(location == "Left the city"){
                  location = locations.getLocation(locationGenerator.generate());
              }
              
              while(location != "Left the city"){
                  System.out.println("Visitor " + (i + 1) + " is going to " + location);
                  
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
