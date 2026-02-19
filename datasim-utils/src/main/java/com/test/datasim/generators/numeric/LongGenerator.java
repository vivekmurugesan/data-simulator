package com.test.datasim.generators.numeric;

import com.test.datasim.generators.UniquenessVerifier;

import java.util.Random;
import java.util.random.RandomGenerator;

public abstract class LongGenerator {

    /** Unique = true with tighter sd with long/int will not work
     * use it carefully
     */
    protected boolean unique;

    protected RandomGenerator rand;

    private UniquenessVerifier<Long> verifier;

    public LongGenerator(boolean unique) {
        this.rand = new Random();
        this.unique = unique;
        this.verifier = new UniquenessVerifier<>(unique);
    }

    protected boolean isUnique(long value){
        return verifier.isUnique(value);
    }

    public abstract long generateNext();
}
