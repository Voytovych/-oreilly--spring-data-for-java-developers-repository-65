package com.oreilly.sdata;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<Book, Long> {
	
	public List<Book> findByPageCountGreaterThan(int pageCount, Sort sort);
}
