package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);

		Slice slice = repository.findByPageCountGreaterThan(120, new PageRequest(0,3));
		
		for (Book b : repository.findByPageCountGreaterThan(120, new PageRequest(0,3))) {
			System.out.println(b);
		}
	}
}
