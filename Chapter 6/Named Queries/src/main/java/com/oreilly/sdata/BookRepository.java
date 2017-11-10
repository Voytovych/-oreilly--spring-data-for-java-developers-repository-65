package com.oreilly.sdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> queryOne();

	public List<Book> queryTwo(int pageCount);

	public List<Book> queryThree(@Param("title") String title);
	
}
