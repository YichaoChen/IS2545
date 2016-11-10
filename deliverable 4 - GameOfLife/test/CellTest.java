/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cyc
 */

import SlowLife.Cell;
import static org.junit.Assert.*;

import org.junit.Test;


// This test class mainly used for testing
// toString method in Cell class
public class CellTest {
    
    // To test whether the modified Cell.toString() can be initialized as the original toString() method
    @Test
    public void testToStringInit() {
        Cell oldToString = new Cell();
        String oldToStringResult = oldToString.toStringOld();
        Cell newToString = new Cell();
        String newToStringResult = newToString.toString();
        assertEquals(oldToStringResult, newToStringResult);
    }
	
	
    // To test whether the modified Cell.toString() can recognize the alive cells
    @Test
    public void testToStringAlive() {
        Cell newToString = new Cell();
        newToString.setAlive(true);
        String newToStringResult = newToString.toString();      
        assertEquals(newToStringResult, "X");
    }
    
    
    // To test whether the modified Cell.toString() can recognize the dead cells
    @Test
    public void testToStringDead() {
        Cell newToString = new Cell();
        newToString.setAlive(false);
        String newToStringResult = newToString.toString();
        assertEquals(newToStringResult, ".");
    
    }
}
