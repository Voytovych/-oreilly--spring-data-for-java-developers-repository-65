package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repo = context.getBean(BookRepository.class);
		
		repo.save(BookUtil.create());
	}
}
