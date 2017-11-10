package com.oreilly.sdata;

import java.text.ParseException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);	
		
		for(Book b:repository.queryTwo(240)){
			System.out.println(b);
		}
	}
}
