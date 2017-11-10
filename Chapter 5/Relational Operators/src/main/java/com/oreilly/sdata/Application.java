package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);	
	
		for(Book b:repository.findByPageCountBetween(160, 220)){
			System.out.println(b);
		}
	}
}
