package com.malina.siteForInteriorDesigner;

import com.malina.siteForInteriorDesigner.entity.PortfolioEntity;
import com.malina.siteForInteriorDesigner.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
@ComponentScan(basePackages = "com.malina")
public class SiteForInteriorDesignerApplication
{
	public static void main(String[] args) {
		SpringApplication.run(SiteForInteriorDesignerApplication.class, args);
	}
}
