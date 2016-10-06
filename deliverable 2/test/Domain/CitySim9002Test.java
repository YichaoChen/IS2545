/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Program.CitySim9002;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 * @author cyc
 */
public class CitySim9002Test {
    
    @Mock
    CitySim9002 mockedCitySim9002 = Mockito.mock(CitySim9002.class);
    RandomGenerator mockedRandom = Mockito.mock(RandomGenerator.class);
    Visitor mockedVisitor = Mockito.mock(Visitor.class);
    Location mockedLocation = Mockito.mock(Location.class);
    Validator mockedValidator = Mockito.mock(Validator.class);
    
    CitySim9002 citySim9002 = new CitySim9002();
    RandomGenerator r = new RandomGenerator(8,5);
    Visitor visitor = new Visitor();
    Location location = new Location();
    Validator validator = new Validator();
    
    
    // Check a valid input "1"
    // return true
    @Test
    public void checkInput(){
        String[] args = {"1"};
        assertEquals(true, validator.validateArguments(args));
    }


    // Check invalid inputs "7", "9"
    // More than one argument, return false
    @Test
    public void checkInputsMoreThanOne(){
        String[] args = {"7","9"};
        assertEquals(false, validator.validateArguments(args));
    }

    // Check an invalid input ""
    // No argument, return false
    @Test
    public void checkNoInput(){
        String[] args = {};
        assertEquals(false, validator.validateArguments(args));
    }


    // Check an invalid input "n"
    // Not an integer, return false
    @Test
    public void checkNotIntegerInput(){
        String[] args = {"n"};
        assertEquals(false, validator.validateArguments(args));
    }
    
    // Mock the Random Generator, set the return value is 1
    // The index 1 of the indentity map in Visitor class is "Professor", not "Business Person"
    // return true
    @Test
    public void checkGetVisitor1(){
        Mockito.when(mockedRandom.generate()).thenReturn(1);
        assertNotEquals("Business Person", visitor.getVisitor(mockedRandom.generate()));
    }


    // Mock the Random Generator, set the return value is 2
    // The index 2 of the indentity map in Visitor class is "Business Person"
    // return true
    @Test
    public void checkGetVisitor2(){
        Mockito.when(mockedRandom.generate()).thenReturn(2);
        assertEquals("Business Person", visitor.getVisitor(mockedRandom.generate()));
    }
    
    
    // Mock the Random Generator, set the return value is 1
    // The index 1 of the loc array in Location class is "Squirrel Hill", not "The point"
    // return true
    @Test
    public void checkGetLocation1(){
        Mockito.when(mockedRandom.generate()).thenReturn(1);
        assertNotEquals("The point", location.getLocation(mockedRandom.generate()));
    }


    // Mock the Random Generator, set the return value is 2
    // The index 2 of the loc array in Location class is "The point"
    // return true
    @Test
    public void checkGetLocation2(){
        Mockito.when(mockedRandom.generate()).thenReturn(2);
        assertEquals("The point", location.getLocation(mockedRandom.generate()));
    }
    
    
    // Check the whether the Student likes "The Cathedral of Learning"
    // The Student dosen't like "The Cathedral of Learning"
    // return true
    @Test
    public void checkVisitorPreference1(){
        Mockito.when(mockedLocation.getLocation(1)).thenReturn("The Cathedral of Learning");
        assertFalse(visitor.getVisitorsPref("Student").contains(mockedLocation.getLocation(1)));
    }
    
    // Check the whether the Student likes "Downtown"
    // The Student likes "Downtown"
    // return true
    @Test
    public void checkVisitorPreference2(){
        Mockito.when(mockedLocation.getLocation(4)).thenReturn("Downtown");
        assertTrue(visitor.getVisitorsPref("Student").contains(mockedLocation.getLocation(4)));
    }
    
    
    // Check whether RandomGenerator can generate a number between 0 and upper limit
    // return true
    @Test
    public void checkRandomNumber(){
        int upperLimit = 10;
        RandomGenerator r = new RandomGenerator(9,upperLimit);      
        int result = r.generate();

        assertTrue(result < upperLimit && result >= 0);
    }
    
    
    // Check whether the visitor has chose "Left the city", the program would
    // give him another chance to pick up a place
    // return true means the visitor has randomly chose to leave
    // so he will need another random pick for location
    @Test
    public void checkFirstVisitLeft(){
        Mockito.when(mockedRandom.generate()).thenReturn(4);
        assertEquals("Left the city", location.getLocation(mockedRandom.generate()));
    }
        
}
