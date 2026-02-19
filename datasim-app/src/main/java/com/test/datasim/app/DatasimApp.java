package com.test.datasim.app;

import com.test.datasim.app.util.CustProfileDataGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan("com.test.data.model")
public class DatasimApp {
    public static void main(String[] args){
        System.out.println("Starting spring app");
        SpringApplication.run(DatasimApp.class);
    }

    @Bean
    public CommandLineRunner demo(CustProfileRepository custProfileRepo){
        return (args) -> {

            System.out.println("Generating CustProfile records");
            //Generating CustProfile data and persisting
            long count = 10000;
            CustProfileDataGenerator generator =
                    new CustProfileDataGenerator(count);
            generator.generate(custProfileRepo);
            long generatedCount = custProfileRepo.count();
            System.out.println("Generated.. ::" + generatedCount +
                    " .. records");
        };
    }
}
