package com.example.aop_pj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@MapperScan("com.example.aop_pj.mapper")
public class AopPjApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopPjApplication.class, args);
	}

}
