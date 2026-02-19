package com.test.datasim.generators.alphanumeric;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StringGeneratorWithPattern {

    private String patternStr;
    private boolean unique;

    private Random rand;
    private Pattern pattern;

    private Set<String> cache;

    public StringGeneratorWithPattern(String patternStr, boolean unique) {
        this.patternStr = patternStr;
        this.unique = unique;
        this.init();
    }

    public void init(){
        this.rand = new Random();
        if(unique)
            this.cache = new HashSet<>();
        this.pattern = new Pattern(this.patternStr.toCharArray());
    }

    public String generateNext(){
        int len = this.patternStr.length();
        StringBuilder builder = new StringBuilder();
        String result;
        boolean done = false;
        do {
            for (int i = 0; i < len; i++) {
                builder.append(this.pattern.generateCharAt(i));
            }
            result = builder.toString();

            if (this.unique){
                if(!this.cache.contains(result)) {
                    this.cache.add(result);
                    done = true;
                }
            }else
                done = true;
        }while (!done);

        return result;
    }

    public static void main(String[] args){
        StringGeneratorWithPattern generator = new StringGeneratorWithPattern(Patterns.AADHAR_IN, true);
        int count = 1000;
        for(int i=0;i<count;i++){
            String result = generator.generateNext();
            System.out.println(result);
        }
    }

}
