package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MongoOperations template = context.getBean(MongoTemplate.class);
		
		Book book = BookUtil.create();
		template.save(book);
		
		Book dbBook = template.findOne(new Query(Criteria.where("bookId").is(book.getBookId())), Book.class);
		
		System.out.println(dbBook);
	}
}
