package com.gary.dbrw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement(order = 10)
@SpringBootApplication
public class DbWrMysqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbWrMysqlApplication.class, args);
    }
}
