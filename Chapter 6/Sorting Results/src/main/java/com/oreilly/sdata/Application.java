package com.oreilly.sdata;

import java.text.ParseException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);	
		
		for(Book b:repository.findAll(new Sort("pageCount"))){
			System.out.println(b);
		}

		for(Book b:repository.findAll(new Sort(Sort.Direction.DESC,"pageCount"))){
			System.out.println(b);
		}
		
		for(Book b:repository.findAll(new Sort(Sort.Direction.ASC, "author.lastName", "pageCount"))){
			System.out.println(b);
		}
		
		for(Book b:repository.findAll(new Sort(Sort.Direction.ASC,"author.lastName").and(new Sort(Sort.Direction.DESC,"pageCount")))){
			System.out.println(b);
		}

		for(Book b:repository.findByPageCountGreaterThan(220, new Sort("author.firstName"))){
			System.out.println(b);
		}
	}
}
