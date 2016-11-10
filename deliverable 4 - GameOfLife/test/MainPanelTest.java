
import SlowLife.Cell;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cyc
 */

import SlowLife.MainPanel;
import java.util.Random;
import static org.junit.Assert.*;

import org.junit.Test;

// This test class mainly used for testing
// backup() method and getNumNeighbors() method in MainPanel class
public class MainPanelTest {
    
    // Because we eliminate the convertToInt() method which only be
    // implemented in getNumNeighbors() method
    // We have to test whether getNumNeighbors() can work properly without convertToInt()
    // The first three test methods are used to test getNumNeighbors()'s performance
    
    
    // To test whether the modified MainPanel.getNumNeighbors() can get the same number
    // of alive neighbors with all cells alive
    @Test
    public void testGetNumNeighborsAlive() {
        MainPanel test = new MainPanel(9);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                test._cells[i][j] = new Cell(true);
            }
        }
        int newResult = test.getNumNeighbors(5,5);
        int oldResult = test.getNumNeighborsOld(5,5);
        assertEquals(newResult, oldResult);
    }
    
    // To test whether the modified MainPanel.getNumNeighbors() can get the same number
    // of alive neighbors with all cells dead (defult status)
    @Test
    public void testGetNumNeighborsDead() {
        MainPanel test = new MainPanel(9);
        int newResult = test.getNumNeighbors(5,5);
        int oldResult = test.getNumNeighborsOld(5,5);
        assertEquals(newResult, oldResult);
    }
    
    // To test whether the modified MainPanel.getNumNeighbors() can get the same number
    // of alive neighbors with all cells status randomly set
    @Test
    public void testGetNumNeighborsRand() {
        Random r = new Random();
        MainPanel test = new MainPanel(9);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                test._cells[i][j] = new Cell(r.nextBoolean());
            }
        }
        int newResult = test.getNumNeighbors(5,5);
        int oldResult = test.getNumNeighborsOld(5,5);
        assertEquals(newResult, oldResult);
    }
    
    
    //Next three test methods are to test backup()
    

    // To test whether the modified MainPanel.backup() can actually save
    // all cell's status by assigning them alive at the beginning
    @Test
    public void testBackupAllAlive() {
        MainPanel test = new MainPanel(15);
        Cell[][] _cells = new Cell[15][15];
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                _cells[i][j] = new Cell(true);
            }
        }	
        test.setCells(_cells);
        test.backup();
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                assertEquals(test._backupCells[i][j].getAlive(), _cells[i][j].getAlive());
            }
        }        
    }
    
    // To test whether the modified MainPanel.backup() can actually save
    // all cell's status by assigning them dead at the beginning
    @Test
    public void testBackupAllDead() {
        MainPanel test = new MainPanel(15);
        Cell[][] _cells = new Cell[15][15];
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                _cells[i][j] = new Cell(false);
            }
        }	
        test.backup();	
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                assertEquals(test._backupCells[i][j].getAlive(), _cells[i][j].getAlive());
            }
        }    
    }
    
    // To test whether the modified MainPanel.backup() can actually save
    // all cell's status by randomly assign their status
    @Test
    public void testBackupRand() {
        Random r = new Random();
        MainPanel test = new MainPanel(15);
        Cell[][] _cells = new Cell[15][15];
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                _cells[i][j] = new Cell(r.nextBoolean());
            }
        }
        test.setCells(_cells);
        test.backup();	
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 15; j++) {
                assertEquals(test._backupCells[i][j].getAlive(), _cells[i][j].getAlive());
            }
        }    
    }
}
