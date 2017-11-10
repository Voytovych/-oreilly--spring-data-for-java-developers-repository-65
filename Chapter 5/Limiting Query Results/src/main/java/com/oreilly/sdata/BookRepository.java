package com.oreilly.sdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public List<Book> findByTitleContainingOrderByTitleAsc(String title);

	public List<Book> findByTitleContainingOrderByTitleDesc(String title);

	public List<Book> findTopByOrderByPageCountDesc();

	public List<Book> findFirstByOrderByPageCountAsc();

	public List<Book> findTop5ByOrderByPriceDesc();

	public List<Book> findTop5ByTitleOrderByPriceAsc(String title);
	
	
}
