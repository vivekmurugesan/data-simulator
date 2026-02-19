package com.test.datasim.generators.numeric;

public class DoubleGeneratorUniformDist extends DoubleGenerator {

    private double begin;
    private double end;

    public DoubleGeneratorUniformDist(boolean unique, double begin, double end) {
        super(unique);
        this.begin = begin;
        this.end = end;
    }

    @Override
    public double generateNext() {
        double result;
        boolean done = false;
        do{
            result = rand.nextDouble(begin, end);
            if(isUnique(result))
                done = true;
        }while (!done);

        return result;
    }

    public static void main(String[] args){
        DoubleGeneratorUniformDist generatorUniform = new DoubleGeneratorUniformDist(true,
                20.0, 2500.0);
        int count = 50;
        for (int i=0;i<count;i++){
            double result = generatorUniform.generateNext();
            System.out.println(result);
        }
    }
}
