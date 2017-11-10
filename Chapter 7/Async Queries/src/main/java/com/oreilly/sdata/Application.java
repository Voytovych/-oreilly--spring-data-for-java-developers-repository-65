package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);

		for(long x = 0; x < 4; x++){
			repository.findByIds(x);
		}	
	}
}
