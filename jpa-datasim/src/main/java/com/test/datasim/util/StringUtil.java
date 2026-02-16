package com.test.datasim.util;

import java.util.Random;

public class StringUtil {
    public static String randString(){
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<10;i++) {
            builder.append((char)('Z' - rand.nextInt(25)));
        }
        return builder.toString();
    }
}
