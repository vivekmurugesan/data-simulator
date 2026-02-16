package com.test.datasim.util;

import com.test.datasim.*;
import com.test.datasim.ProductRating.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RatingDataUtil {

    private static final Logger log = LoggerFactory.getLogger(RatingDataUtil.class);
    private static final int MAX_RATING = 50;

    public static void generate(CustomerRepository custRepo, ProductRepository prodRepo,
                                ProductRatingRepository ratingRepository){
        Iterable<Customer> custIter = custRepo.findAll();
        List<Product> prodList = new ArrayList<>();
        log.info("Generating rating for " + prodList.size() + " products");
        prodRepo.findAll().forEach(prodList::add);
        for(Customer cust: custIter){
            log.info("Generating rating for customer:: " + cust.getId());
            generateRatingForCustomer(ratingRepository,
                    cust, prodList);
        }

    }

    private static void generateRatingForCustomer(ProductRatingRepository ratingRepository,
            Customer cust, List<Product> prodList){
        Random rand = new Random();
        int count = rand.nextInt(MAX_RATING);
        int prodSize = prodList.size();
        for(int i=0;i<count;i++){
            int prodIdx = rand.nextInt(prodSize-1);
            Product product = prodList.get(prodIdx);
            Rating rating = generateRandRating(rand);
            Date date = RandomTimestampUtil.generateRandTimeStamp();
            ratingRepository.save(new ProductRating(cust, product,
                    date, rating));
        }
    }

    private static Rating generateRandRating(Random rand){
        int rating = rand.nextInt(5);
        switch (rating){
            case 1:
                return Rating.one;
            case 2:
                return Rating.two;
            case 3:
                return Rating.three;
            case 4:
                return Rating.four;
            default:
                return Rating.five;
        }
    }
}
