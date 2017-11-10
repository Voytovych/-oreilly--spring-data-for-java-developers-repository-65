package com.oreilly.sdata;

import org.springframework.core.convert.converter.Converter;

import com.mongodb.DBObject;

public class DbObjectToAuthorConverter implements Converter<DBObject, Author> {

	public Author convert(DBObject source) {
		Author author = new Author();
		author.setCountry(source.get("country").toString());
		author.setFirstName(source.get("name").toString().split(" ")[0]);
		author.setLastName(source.get("name").toString().split(" ")[1]);
		return author;
	}

}
