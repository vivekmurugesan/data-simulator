package com.test.datasim.generators.numeric;

import com.test.datasim.generators.UniquenessVerifier;

import java.util.Random;
import java.util.random.RandomGenerator;

public abstract class DoubleGenerator {
    protected boolean unique;

    protected RandomGenerator rand;

    private UniquenessVerifier<Double> verifier;

    public DoubleGenerator(boolean unique) {
        this.rand = new Random();
        this.unique = unique;
        this.verifier = new UniquenessVerifier<>(unique);
    }

    protected boolean isUnique(double value){
        return verifier.isUnique(value);
    }

    public abstract double generateNext();
}
