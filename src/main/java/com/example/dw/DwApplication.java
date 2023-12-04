package com.example.dw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
// JPA Auditing 기능을 사용하기 위해 사용
@SpringBootApplication
public class DwApplication {

    public static void main(String[] args) {
        SpringApplication.run(DwApplication.class, args);
    }

}
