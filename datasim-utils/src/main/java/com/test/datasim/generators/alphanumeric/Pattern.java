package com.test.datasim.generators.alphanumeric;

import java.util.Random;

/**
 *
 */
public class Pattern {

    /**
     * n - digit (0-9)
     * c - char lower case (a-z)
     * C - char uppper case (A-Z)
     * w - whitespace (single)
     */
    private char[] patternSeq;
    private Random rand;

    public Pattern(char[] patternSeq) {
        this.patternSeq = patternSeq;
        this.rand = new Random();
        if(!validate(patternSeq))
            throw new IllegalArgumentException("Illegal pattern detected::" + new String(patternSeq));
    }

    public boolean validate(char[] patternSeq){
        boolean valid = true;
        for(char c : patternSeq){
            if(!(c == 'n' || c == 'c' || c == 'C' || c == 'w')) {
                valid = false;
                break;
            }
        }

        return valid;
    }

    public char generateCharAt(int index){
        char patternChar = this.patternSeq[index];
        char result;

        switch (patternChar){
            case 'n':
                result = Character.toChars('9'- rand.nextInt(9))[0];
                break;
            case 'c':
                result = Character.toChars('z' - rand.nextInt(25))[0];
                break;
            case 'C':
                result = Character.toChars('Z' - rand.nextInt(25))[0];
                break;
            case 'w':
                result = ' ';
                break;
            default:
                result = ' ';
                break;
        }

        return result;
    }

}
