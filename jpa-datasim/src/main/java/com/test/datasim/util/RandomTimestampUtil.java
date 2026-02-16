package com.test.datasim.util;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Random;

public class RandomTimestampUtil {
    // 30 days in seconds
    private static final int MAX_HISTORY_TIME = 30 * 24 * 60 * 60;
    public static Date generateRandTimeStamp() {
        Random rand = new Random();
        long toGoBackInMillis = rand.nextInt(MAX_HISTORY_TIME) * 1000L;
        long timestampInMillis = System.currentTimeMillis() - toGoBackInMillis;
        return new Date(timestampInMillis);
    }
}
