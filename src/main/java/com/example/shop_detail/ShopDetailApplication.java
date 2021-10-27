package com.example.shop_detail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.shop_detail.mapper")
public class ShopDetailApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopDetailApplication.class, args);
    }

}
