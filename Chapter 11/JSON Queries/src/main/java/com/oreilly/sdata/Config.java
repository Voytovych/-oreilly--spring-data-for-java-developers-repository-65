package com.oreilly.sdata;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class Config {

	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException{
		MongoClientURI uri = new MongoClientURI("mongodb://books:password@localhost/sandbox");
		return new SimpleMongoDbFactory(new MongoClient(uri), "sandbox");
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException{
		return new MongoTemplate(mongoDbFactory());
	}
	
	
	
	
	
	
	
}
