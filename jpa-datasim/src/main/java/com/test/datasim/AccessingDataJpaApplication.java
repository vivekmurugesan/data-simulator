package com.test.datasim;

import com.test.datasim.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {

        SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository custRepo, ProductRepository prodRepo,
                                  TelemetryRepository telemetryRepo, ProductRatingRepository ratingRepo,
                                  TransactionRepository transactionRepo) {
		return (args) -> {
            log.info("Generating data..");
            long totalRecordCount = 0L;
            long custRecordCount;
            long prodRecordCount;
            long ratingRecordCount;
            long telemetryRecordCount;
            long transRecordCount;

            // Generating data..
            log.info("Generating data.. for customers..");
            CustomerDataUtil.generate(custRepo);
            custRecordCount = custRepo.count();
            log.info(custRecordCount +" -- records generated for Customers..");

            log.info("Generating data.. for products..");
            ProductDataUtil.generate(prodRepo);
            prodRecordCount = prodRepo.count();
            log.info(prodRecordCount +" -- records generated for Products..");


            log.info("Generating data.. for rating..");
            RatingDataUtil.generate(custRepo, prodRepo, ratingRepo);
            ratingRecordCount = ratingRepo.count();
            log.info(ratingRecordCount +" -- records generated for Rating..");

            log.info("Generating data.. for telemetry..");
            TelemetryDataUtil.generate(custRepo, telemetryRepo);
            telemetryRecordCount = telemetryRepo.count();
            log.info(telemetryRecordCount +" -- records generated for Telemetry..");

            log.info("Generating data.. for transactions..");
            TransactionDataUtil.generate(custRepo, prodRepo, transactionRepo);
            transRecordCount = transactionRepo.count();
            log.info(transRecordCount +" -- records generated for Transaction..");

            log.info("Data generation completed..");
            totalRecordCount = custRecordCount + prodRecordCount +
                    telemetryRecordCount + ratingRecordCount + transRecordCount;

            log.info("Total number of records generated.." + totalRecordCount);
            log.info(custRecordCount +" -- records generated for Customers..");
            log.info(prodRecordCount +" -- records generated for Products..");
            log.info(ratingRecordCount +" -- records generated for Rating..");
            log.info(telemetryRecordCount +" -- records generated for Telemetry..");
            log.info(transRecordCount +" -- records generated for Transaction..");

			/** repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info(""); */
		};
	}

}
