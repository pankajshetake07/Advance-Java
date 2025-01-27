package com.knowit.SpringBootMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootMvcApplication {

	public static void main(String[] args) {
		 ApplicationContext ctx =  SpringApplication.run(SpringBootMvcApplication.class, args);
		 String [] beans = ctx.getBeanDefinitionNames();
		 for(String s : beans) {
			 System.out.println(s);
		 }
	
	}

}
