package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MongoOperations template = context.getBean(MongoTemplate.class);
		
		BasicQuery query = new BasicQuery("{title:'Brave New World'}");
		Book book = template.find(query, Book.class).get(0);
		book.setTitle("I have been updated");
		template.save(book);
	}
}
