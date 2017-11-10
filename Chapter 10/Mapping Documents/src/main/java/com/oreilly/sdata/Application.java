package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MongoTemplate template = context.getBean(MongoTemplate.class);

		Book book = BookUtil.create();
		template.insert(book);
	}
}
