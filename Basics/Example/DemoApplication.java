package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		
		ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
		Helloworld obj=(Helloworld)context.getBean("Helloworld");
		obj.getMessage();
	}

}
