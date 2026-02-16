package com.test.datasim.util;

import com.test.datasim.Customer;
import com.test.datasim.CustomerRepository;

import static com.test.datasim.util.StringUtil.randString;

public class CustomerDataUtil {
    public static void generate(CustomerRepository repository){
        // Generating 1000 random customer records
        for (int i=0;i<1000;i++) {
            repository.save(new Customer(randString(), randString()));
        }
    }

}
