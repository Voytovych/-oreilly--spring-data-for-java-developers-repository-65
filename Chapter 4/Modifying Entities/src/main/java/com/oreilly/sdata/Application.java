package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);

		System.out.println(repository.findOne(1L));
		Book book = BookUtil.create();
		//book.setBookId(1L);
		book.setTitle("War and Piece");
		repository.save(book);
		System.out.println(repository.findOne(1L));
	}
}
