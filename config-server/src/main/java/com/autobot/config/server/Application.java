package com.autobot.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * config-server 通过Git 在本地仓库暂存，可以有效防止当 Git 仓库出现故障而引起 无法加载配置信息的情况。
 * 
 *
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
