package com.oreilly.sdata;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.query.TextCriteria;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repo = context.getBean(BookRepository.class);

		List<Book> books = repo.findLargeBooks(300);
		
		for(Book b:books){
			System.out.println(b);
		}
	}
}
