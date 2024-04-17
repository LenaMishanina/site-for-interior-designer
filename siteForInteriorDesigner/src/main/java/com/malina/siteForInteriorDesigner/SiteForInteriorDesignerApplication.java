package com.malina.siteForInteriorDesigner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.malina")
public class SiteForInteriorDesignerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiteForInteriorDesignerApplication.class, args);
	}

}
