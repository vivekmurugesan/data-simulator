package com.test.datasim.generators.numeric;

public class DoubleGeneratorNormalDist extends DoubleGenerator {

    private double mean;
    private double sd;

    public DoubleGeneratorNormalDist(boolean unique, double mean, double sd) {
        super(unique);
        this.mean = mean;
        this.sd = sd;
    }

    @Override
    public double generateNext() {
        double result;
        boolean done = false;
        do{
            result = rand.nextGaussian(this.mean, this.sd);
            if(isUnique(result))
                done = true;
        }while (!done);

        return result;
    }

    public static void main(String[] args){
        DoubleGeneratorNormalDist generatorNormal = new DoubleGeneratorNormalDist(true, 1000, 25);
        int count = 50;
        for (int i=0;i<count;i++){
            double result = generatorNormal.generateNext();
            System.out.println(result);
        }
    }
}
