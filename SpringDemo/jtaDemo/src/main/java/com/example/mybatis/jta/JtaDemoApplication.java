package com.example.mybatis.jta;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatis.jta.mapper")
public class JtaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtaDemoApplication.class, args);
	}

}
