package com.oreilly.sdata;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.oreilly.sdata.data.entities.Book;
import com.oreilly.sdata.data.repository.BookRepository;

@SpringBootApplication
public class SpringDataDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataDemoApplication.class, args);
        BookRepository repository = context.getBean(BookRepository.class);
        Book book = new Book();
        book.setTitle("The Book of Wisdom");
        book.setPageCount(200);
        book.setPrice(new BigDecimal("100.00"));
        book.setPublishDate(new Date());

        repository.save(book);    
    }
}
