package com.work.logs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.work.logs.mapper")
public class WorkLogsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkLogsApiApplication.class, args);
    }

}
