package com.oreilly.sdata;

import java.text.ParseException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);	
		
		for(Book b:repository.findByPageCountGreaterThan(150, new PageRequest(1,3))){
			System.out.println(b);
		}
	}
}
