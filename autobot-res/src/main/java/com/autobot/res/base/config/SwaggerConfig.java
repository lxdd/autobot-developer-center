package com.autobot.res.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置类
 * 
 * 特别要注意的是里面配置了api文件也就是controller包的路径，不然生成的文档扫描不到接口
 * 
 * @Configuation等价于<Beans></Beans>
 * 
 * @Bean等价于<Bean></Bean>
 * 
 * @ComponentScan等价于<context:component-scan base-package="com.dxz.demo"/>
 * 
 * @author li_xiaodong
 *
 */
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.autobot.res.adc")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("springboot利用swagger构建api文档")
				.description("简单优雅的restfun风格,lxd个人网站:，http://lxdyun.com:8100")
				.termsOfServiceUrl("http://lxdyun.com:8100").version("1.0").build();
	}
}
