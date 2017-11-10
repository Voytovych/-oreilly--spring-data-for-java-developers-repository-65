package com.oreilly.sdata;

import static org.springframework.data.mongodb.core.query.Update.update;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MongoOperations template = context.getBean(MongoTemplate.class);
		
		template.save(BookUtil.create());
		template.save(BookUtil.create());
		template.save(BookUtil.create());
		
		Query query = new Query();
		Update update = update("title","Using Multi");
		template.updateMulti(query, update, Book.class);
	}
}
