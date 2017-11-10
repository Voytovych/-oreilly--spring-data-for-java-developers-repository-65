package com.oreilly.sdata;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);
		
		repository.delete(1L);
		
		repository.delete(repository.findOne(2L));
		
		repository.delete(repository.findAll(new ArrayList<Long>(){{
			add(3L);
			add(4L);
		}}));

		repository.deleteInBatch(repository.findAll(new ArrayList<Long>(){{
			add(5L);
			add(6L);
		}}));
		
		repository.deleteAll();
		
		repository.deleteAllInBatch();
		
	}
}
