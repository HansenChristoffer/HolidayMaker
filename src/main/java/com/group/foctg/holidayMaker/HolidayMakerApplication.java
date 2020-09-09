package com.group.foctg.holidayMaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan(basePackages = {"com.group.foctg.holidayMaker.model"})
public class HolidayMakerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HolidayMakerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(HolidayMakerApplication.class, args);
    }

}
