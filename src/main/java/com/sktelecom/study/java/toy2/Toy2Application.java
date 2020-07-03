package com.sktelecom.study.java.toy2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Toy2Application {

    public static void main(String[] args) {
        SpringApplication.run(Toy2Application.class, args);
    }

}
