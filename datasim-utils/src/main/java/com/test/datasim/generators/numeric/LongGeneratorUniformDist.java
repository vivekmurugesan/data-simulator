package com.test.datasim.generators.numeric;

/**
 * @author vivekmurugesan
 *  * Provides capability to generate numerical values by following uniform distribution
 *  * Based on the range defined by begin and end
 */
public class LongGeneratorUniformDist extends LongGenerator {
    private long begin;
    private long end;

    public LongGeneratorUniformDist(boolean unique, long begin, long end) {
        super(unique);
        this.begin = begin;
        this.end = end;
    }

    @Override
    public long generateNext() {
        long result;
        boolean done = false;
        do{
            result = rand.nextLong(begin, end);
            if(isUnique(result))
                done = true;
        }while (!done);

        return result;
    }

    public static void main(String[] args){
        LongGeneratorUniformDist generatorNormal = new LongGeneratorUniformDist(true, 50, 10000);
        int count = 500;
        for (int i=0;i<count;i++){
            long result = generatorNormal.generateNext();
            System.out.println(result);
        }
    }
}
