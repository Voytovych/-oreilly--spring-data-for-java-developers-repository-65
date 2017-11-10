package com.oreilly.sdata;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);
		
		List<Book> books = BookUtil.create(5);		
		repository.save(books);
	}
}
