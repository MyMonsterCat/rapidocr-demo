package com.zcloud.veight.model;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Monster
 */
@SpringBootApplication(scanBasePackages= {"com.zcloud.veight.model"})
@MapperScan("com.zcloud.veight.model.mapper")
public class ModelServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelServerApplication.class, args);
    }
}
