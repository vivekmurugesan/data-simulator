package com.test.datasim.generators.numeric;

/**
 * @author vivekmurugesan
 * Provides capability to generate numerical values by following normal distribution
 * Based on the mean and std deviation provided as input.
 */
public class LongGeneratorNormalDist extends LongGenerator {
    private double mean;
    private double sd;


    public LongGeneratorNormalDist(long mean, long sd, boolean unique) {
        super(unique);
        this.mean = mean;
        this.sd = sd;
    }

    public long generateNext(){
        long result;
        boolean done = false;
        do{
            result = Math.round(rand.nextGaussian(this.mean, this.sd));
            if(isUnique(result))
                done = true;
        }while (!done);

        return result;
    }

    public static void main(String[] args){
        LongGeneratorNormalDist generatorNormal = new LongGeneratorNormalDist(1000, 50, true);
        int count = 50;
        for (int i=0;i<count;i++){
            long result = generatorNormal.generateNext();
            System.out.println(result);
        }
    }
}
