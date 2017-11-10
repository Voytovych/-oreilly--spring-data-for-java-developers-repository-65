package com.oreilly.sdata;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MongoOperations template = context.getBean(MongoTemplate.class);
		
//		Criteria criteria = Criteria.where("title").is("Moby Dick");
		Criteria criteria = Criteria.where("title").regex(Pattern.compile(".*of.*"));
		Query query = new Query(criteria).addCriteria(Criteria.where("pageCount").gt(300));
		
		List<Book> books = template.find(query, Book.class);
		for(Book book:books){
			System.out.println(book);
		}
	}
}
