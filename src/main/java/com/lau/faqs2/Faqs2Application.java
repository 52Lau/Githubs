package com.lau.faqs2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;

@Controller
@EnableWebMvc
@SpringBootApplication
@MapperScan(basePackages = "com.lau.faqs2.mapper")
public class Faqs2Application extends WebMvcConfigurerAdapter implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(Faqs2Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Faqs2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		logger.info("服务启动完成!");
	}
	@RequestMapping("/")
	String home() {
		return "redirect:faqs2";
	}
}
