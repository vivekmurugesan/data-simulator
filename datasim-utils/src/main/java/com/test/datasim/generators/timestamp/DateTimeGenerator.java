package com.test.datasim.generators.timestamp;

import com.test.datasim.generators.UniquenessVerifier;

import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.Random;

/**
 * Capable of generating random date values.
 * With support for generating,
 *   - java.sql.Date
 *   - java.sql.Timestamp
 *   - java.sql.Time
 * Based on a range of days to go back from current day with values of start and end
 * @author vivekmurugesan
 */
public class DateTimeGenerator {
    private int daysToGobackStart;
    private int daysToGobackEnd;
    private boolean unique;

    private Random rand;
    private UniquenessVerifier<Date> uniquenessVerifier;
    private UniquenessVerifier<Timestamp> timestampUniquenessVerifier;
    private UniquenessVerifier<Time> timeUniquenessVerifier;

    private long millisToGoBackStart;
    private long getMillisToGoBackEnd;

    public DateTimeGenerator(int daysToGobackStart, int daysToGobackEnd, boolean unique) {
        this.daysToGobackStart = daysToGobackStart;
        this.daysToGobackEnd = daysToGobackEnd;
        this.unique = unique;
        this.uniquenessVerifier = new UniquenessVerifier<>(unique);
        this.timestampUniquenessVerifier = new UniquenessVerifier<>(unique);
        this.timeUniquenessVerifier = new UniquenessVerifier<>(unique);
    }

    private void init(){
        this.millisToGoBackStart = daysToGobackStart * 24 * 60 * 60 * 1000L;
        this.getMillisToGoBackEnd = daysToGobackEnd * 24 * 60 * 60 * 1000L;
    }

    private long computeRandTimestampInMillis(){
        long toGoBackInMillis = rand.nextLong(this.millisToGoBackStart, this.getMillisToGoBackEnd);
        long timestampInMillis = System.currentTimeMillis() - toGoBackInMillis;

        return timestampInMillis;
    }

    public Date generateNextDate(){

        long timestampInMillis = computeRandTimestampInMillis();
        boolean done = false;
        Date result;

        do{
            result = new Date(timestampInMillis);
            if(this.uniquenessVerifier.isUnique(result)){
                done = true;
            }
        }while(!done);

        return result;
    }

    public Timestamp generateNextDateTime(){
        long timestampInMillis = computeRandTimestampInMillis();
        boolean done = false;
        Timestamp result;

        do{
            result = new Timestamp(timestampInMillis);
            if(this.timestampUniquenessVerifier.isUnique(result)){
                done = true;
            }
        }while(!done);

        return result;
    }

    public Time generateNextTime(){
        long timestampInMillis = computeRandTimestampInMillis();
        boolean done = false;
        Time result;

        do{
            result = new Time(timestampInMillis);
            if(this.timeUniquenessVerifier.isUnique(result)){
                done = true;
            }
        }while(!done);

        return result;
    }

}
