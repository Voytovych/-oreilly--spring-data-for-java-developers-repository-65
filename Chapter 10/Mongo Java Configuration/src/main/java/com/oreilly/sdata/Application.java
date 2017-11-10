package com.oreilly.sdata;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MongoOperations template = context.getBean(MongoTemplate.class);
		
		Criteria criteria = Criteria.where("title").regex(Pattern.compile(".*of.*"));
		Query query = new Query(criteria).addCriteria(Criteria.where("pageCount").gt(300));
		
		List<Book> books = template.find(query, Book.class);
		for(Book book:books){
			System.out.println(book);
		}
	}
}
