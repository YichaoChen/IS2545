/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.Random;

/**
 *
 * @author cyc
 */
public class RandomGenerator {
    
    private int seed;
    private int upperLimit;
    Random r = new Random(seed);
    
    public RandomGenerator(int seed, int upperLimit){
        this.seed = seed;
        this.upperLimit = upperLimit;
    }
    
    public int generate(){       
        return r.nextInt(upperLimit);
    }
    
}
