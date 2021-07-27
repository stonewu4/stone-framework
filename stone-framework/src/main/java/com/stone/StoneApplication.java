package com.stone;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@MapperScan(basePackages = "com.stone.mapper")
@EnableTransactionManagement
@EnableScheduling
@RestController
@SpringBootApplication
public class StoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoneApplication.class, args);
    }
    //解决myBatisPlus分页失效问题
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
