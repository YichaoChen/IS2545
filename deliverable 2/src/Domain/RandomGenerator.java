/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.Random;

/**
 *
 * @author cyc
 */
public class RandomGenerator {
    
    public int seed;
    public int upperLimit;
    Random r = new Random(seed);
    
    // Get seed and limit
    public RandomGenerator(int seed, int upperLimit){
        this.seed = seed;
        this.upperLimit = upperLimit;
    }
    
    // Generate a random number according to the seed and the upper limit received
    public int generate(){       
        return r.nextInt(upperLimit);
    }
    
}
