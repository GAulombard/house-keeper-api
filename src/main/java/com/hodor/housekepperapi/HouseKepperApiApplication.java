package com.hodor.housekepperapi;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class HouseKepperApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseKepperApiApplication.class, args);
    }

}
