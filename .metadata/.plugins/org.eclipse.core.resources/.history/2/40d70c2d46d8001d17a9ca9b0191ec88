package com.ust.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBean {
	public static void main(String[] args) {
		ApplicationContext ctxt= new AnnotationConfigApplicationContext(Appconfig.class);
		HelloWorld hello= (HelloWorld)ctxt.getBean("helloBean");
		System.out.println(hello.message());
	}
}
