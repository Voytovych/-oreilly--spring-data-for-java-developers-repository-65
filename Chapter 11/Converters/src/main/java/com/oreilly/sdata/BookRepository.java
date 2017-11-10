package com.oreilly.sdata;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BookRepository extends MongoRepository<Book, String> {
	
	@Query(value="{'pageCount':{$gt:?0}}",fields="{'title':1,'pageCount':1}")
	public List<Book> findLargeBooks(int pageCount);
	
	public Book findByTitle(String title);

	public List<Book> findByLocationCoordsNear(Point point, Distance distance);

	public List<Book> findAllByOrderByScoreDesc(TextCriteria criteria);
}
