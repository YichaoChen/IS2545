/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Program.CitySim9002;
import Program.Location;
import Program.RandomGenerator;
import Program.Visitor;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
    
    CitySim9002 citySim9002 = new CitySim9002();
    RandomGenerator r = new RandomGenerator(9,5);
    Visitor visitor = new Visitor();
    Location location = new Location();
    
//    @Before
//    public void setUp() throws Exception {
//        
//        MockitoAnnotations.initMocks(mockedCitySim9002);
//        MockitoAnnotations.initMocks(mockedRandom);
//        MockitoAnnotations.initMocks(mockedVisitor);
//        MockitoAnnotations.initMocks(mockedLocation);
//
//    }
    
    // Mock the Random Generator, set the return value is 1
    // The index 1 of the indentity map in Visitor class is "Professor", not "Business Person"
    // return true
    @Test
    public void checkGetVisitor1() {
        Mockito.when(mockedRandom.generate()).thenReturn(1);
        assertNotEquals("Business Person", visitor.getVisitor(mockedRandom.generate()));
    }


    // Mock the Random Generator, set the return value is 2
    // The index 2 of the indentity map in Visitor class is "Business Person"
    // return true
    @Test
    public void checkGetVisitor2() {
        Mockito.when(mockedRandom.generate()).thenReturn(2);
        assertEquals("Business Person", visitor.getVisitor(mockedRandom.generate()));
    }
    
    
    // Mock the Random Generator, set the return value is 1
    // The index 1 of the loc array in Location class is "The Cathedral of Learning", not "The point"
    // return true
    @Test
    public void checkGetLocation1() {
        Mockito.when(mockedRandom.generate()).thenReturn(1);
        assertNotEquals("The point", location.getLocation(mockedRandom.generate()));
    }


    // Mock the Random Generator, set the return value is 2
    // The index 2 of the loc array in Location class is "Squirrel Hill"
    // return true
    @Test
    public void checkGetLocation2() {
        Mockito.when(mockedRandom.generate()).thenReturn(2);
        assertEquals("Squirrel Hill", location.getLocation(mockedRandom.generate()));
    }
    
    
    // Check the whether the Student likes "The Cathedral of Learning"
    // The Student dosen't like "The Cathedral of Learning"
    // return true
    @Test
    public void checkVisitorPreference1() {
        Mockito.when(mockedLocation.getLocation(1)).thenReturn("The Cathedral of Learning");
        assertFalse(visitor.getVisitorsPref("Student").contains(mockedLocation.getLocation(1)));
    }
    
    // Check the whether the Student likes "Downtown"
    // The Student likes "Downtown"
    // return true
    @Test
    public void checkVisitorPreference2() {
        Mockito.when(mockedLocation.getLocation(4)).thenReturn("Downtown");
        assertTrue(visitor.getVisitorsPref("Student").contains(mockedLocation.getLocation(4)));
    }
    
}
