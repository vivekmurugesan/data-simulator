package com.test.datasim.util;

import com.test.datasim.*;
import com.test.datasim.Customer;
import com.test.datasim.CustomerRepository;
import com.test.datasim.Telemetry;
import com.test.datasim.Telemetry.EventType;

import com.test.datasim.TelemetryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.Random;

public class TelemetryDataUtil {

    private static final Logger log = LoggerFactory.getLogger(TelemetryDataUtil.class);
    private static final int MAX_EVENTS = 100;

    public static void generate(CustomerRepository custRepo,
                                TelemetryRepository telemetryRepository){
        Iterable<Customer> custIter = custRepo.findAll();
        for(Customer cust: custIter){
            log.info("Generating telemetry for customer:: " + cust.getId());
            generateTelemetryForCustomer(telemetryRepository,
                    cust);
        }
    }

    private static void generateTelemetryForCustomer(TelemetryRepository telemetryRepository,
                                                     Customer cust){
        Random rand = new Random();
        int count = rand.nextInt(MAX_EVENTS);
        for(int i=0;i<count;i++){
            EventType type = generatRandEventType(rand);
            Date timestamp = RandomTimestampUtil.generateRandTimeStamp();
            telemetryRepository.save(new Telemetry(cust, timestamp, type));
        }
    }

    private static EventType generatRandEventType(Random rand){
        int type = rand.nextInt(3);
        switch (type){
            case 1:
                return EventType.login;
            case 2:
                return EventType.browse;
            default:
                return EventType.logout;
        }
    }
}
