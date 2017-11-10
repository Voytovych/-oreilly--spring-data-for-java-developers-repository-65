package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);

		System.out.println(repository.setPageCount("%and%", 1000));
		
		for(Book b:repository.findAll()){
			System.out.println(b);
		}
	}
}
