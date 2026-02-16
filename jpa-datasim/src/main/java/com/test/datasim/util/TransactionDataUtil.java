package com.test.datasim.util;

import com.test.datasim.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionDataUtil {
    private static final Logger log = LoggerFactory.getLogger(TransactionDataUtil.class);

    private static final int MAX_QUANTITY = 10;
    private static final int MAX_TRANS = 30;

    public static void generate(CustomerRepository custRepo, ProductRepository prodRepo,
                                TransactionRepository transRepository){
        Iterable<Customer> custIter = custRepo.findAll();
        List<Product> prodList = new ArrayList<>();
        log.info("Generating transactions for " + prodList.size() + " products");
        prodRepo.findAll().forEach(prodList::add);
        for(Customer cust: custIter){
            log.info("Generating transactions for customer:: " + cust.getId());
            generateTransactionsForCustomer(transRepository,
                    cust, prodList);
        }

    }

    private static void generateTransactionsForCustomer(TransactionRepository transRepository,
                                                        Customer cust, List<Product> prodList){
        Random rand = new Random();
        int count = rand.nextInt(MAX_TRANS);
        int prodSize = prodList.size();
        for(int i=0;i<count;i++){
            int prodIdx = rand.nextInt(prodSize-1);
            Product product = prodList.get(prodIdx);
            int quantity = rand.nextInt(MAX_QUANTITY);
            Date timestamp = RandomTimestampUtil.generateRandTimeStamp();
            transRepository.save(new Transaction(cust, product,
                    timestamp, quantity));
        }
    }

}
