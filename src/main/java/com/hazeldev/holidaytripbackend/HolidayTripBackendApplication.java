package com.hazeldev.holidaytripbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HolidayTripBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HolidayTripBackendApplication.class, args);
    }

}
