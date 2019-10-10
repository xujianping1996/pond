package com.jianping.pond;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@MapperScan("com.jianping.pond.dao")
@SpringBootApplication
public class PondApplication {

    public static void main(String[] args) {
        SpringApplication.run(PondApplication.class, args);
    }

}
