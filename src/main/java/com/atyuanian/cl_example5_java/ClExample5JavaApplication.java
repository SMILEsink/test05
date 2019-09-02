package com.atyuanian.cl_example5_java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@MapperScan("com.atyuanian.cl_example5_java.Mapper")
public class ClExample5JavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClExample5JavaApplication.class, args);
    }

}
