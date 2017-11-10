package com.oreilly.sdata;

import org.springframework.core.convert.converter.Converter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class AuthorToDbObjectConverter implements Converter<Author, DBObject> {

	public DBObject convert(Author source) {
		DBObject obj = new BasicDBObject();
		obj.put("name", source.getFirstName() + " "+ source.getLastName());
		obj.put("country", source.getCountry());
		return obj;
	}

}
