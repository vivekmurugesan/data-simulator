package com.test.datasim.generators;

import java.util.HashSet;
import java.util.Set;

public class UniquenessVerifier<T> {
    protected boolean unique;

    private Set<T> cache;

    public UniquenessVerifier(boolean unique) {
        this.unique = unique;

        if(unique)
            this.cache = new HashSet<>();
    }

    public boolean isUnique(T value){
        if(!this.unique)
            return true;
        if(!cache.contains(value)){
            cache.add(value);
            return true;
        }
        return false;
    }


}
