package com.oreilly.sdata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repository = context.getBean(BookRepository.class);	
		
		Date date = new SimpleDateFormat("MM/dd/yyyy").parse("10/22/1995");
		Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse("10/22/1997");
		for(Book b:repository.findByPublishDateBetween(date,date2)){
			System.out.println(b);
		}
	}
}
