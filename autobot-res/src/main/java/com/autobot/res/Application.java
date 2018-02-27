package com.autobot.res;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author li_xiaodong
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("com.autobot.res.adc.dao.*Mapper")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
