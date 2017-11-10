package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);

		Book book = BookUtil.create();
		repository.save(book);
		
		System.out.println(repository.findOne(book.getBookId()));
	}
}
