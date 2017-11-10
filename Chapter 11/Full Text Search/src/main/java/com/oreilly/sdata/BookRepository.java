package com.oreilly.sdata;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
	
	public Book findByTitle(String title);

	public List<Book> findByLocationCoordsNear(Point point, Distance distance);

	public List<Book> findAllByOrderByScoreDesc(TextCriteria criteria);
}
