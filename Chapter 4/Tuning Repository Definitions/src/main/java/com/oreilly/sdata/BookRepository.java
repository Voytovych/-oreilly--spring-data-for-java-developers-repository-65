package com.oreilly.sdata;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReadOnlyRepository<Book, Long> {

}
