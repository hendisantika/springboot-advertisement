package com.hendisantika;

import com.hendisantika.config.DBInit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAdvertisementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdvertisementApplication.class, args);
    }

    @Bean
    public CommandLineRunner DBInit() {
        return new DBInit();
    }
}
