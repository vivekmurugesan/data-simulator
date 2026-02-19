package com.test.datasim.generators;

import java.util.Random;

/**
 *
 */
public class StringGenerator {
    private int length;

    public StringGenerator(int len){
        this.length = len;
    }

    public String generate(){
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<this.length;i++) {
            if(lowerCase(rand))
                builder.append((char)('z' - rand.nextInt(25)));
            else
                builder.append((char)('Z' - rand.nextInt(25)));
        }
        return builder.toString();
    }

    private boolean lowerCase(Random rand){
        return rand.nextBoolean();
    }

}
