package com.ezen.basic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// com.ezen.basic.mapper 패키지의 Mapper 인터페이스를 bean으로 생성하는 역할.
@MapperScan(basePackages = { "com.ezen.basic.mapper" })
@SpringBootApplication
public class Study04Application {

	public static void main(String[] args) {
		SpringApplication.run(Study04Application.class, args);
	}
}
