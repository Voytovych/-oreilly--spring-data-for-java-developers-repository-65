package com.oreilly.sdata;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		MongoClient client = (MongoClient) context.getBean("mongoClient");
		DB db = client.getDB("sandbox");
		DBCollection collection = db.getCollection("book");
		collection.insert(new BasicDBObject().append("title", "Harry Potter"));
	}
}
