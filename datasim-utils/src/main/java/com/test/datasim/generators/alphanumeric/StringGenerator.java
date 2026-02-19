package com.test.datasim.generators.alphanumeric;


import java.util.Random;

public class StringGenerator {
    private int length;

    public StringGenerator(int len){
        this.length = len;
    }

    public String generate(){
        return generate(this.length);
    }

    public String generate(int len){
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<len;i++) {
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

    public static void main(String[] args){
        Random rand = new Random();
        StringGenerator generator = new StringGenerator(10);
        for(int i=0;i<1000;i++){
            int len = 20 - rand.nextInt(10);
            //System.out.println("Of length:" + len);
            String result = generator.generate(len);
            System.out.println(result);
        }
    }

}
