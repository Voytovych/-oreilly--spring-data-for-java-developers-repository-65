package com.oreilly.sdata;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MongoOperations template = context.getBean(MongoTemplate.class);

		Query query = new Query(where("title").is("To Kill a Mocking Bird").and("author.firstName").is("Bob")
				.and("author.lastName").is("Smith"));
		
		template.remove(query, Book.class);
	}
}
