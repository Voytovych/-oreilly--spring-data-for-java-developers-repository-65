package com.oreilly.sdata;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

public class Application {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		BookRepository repo = context.getBean(BookRepository.class);

		Point boston = new Point(-71.061973,42.356940);
		Distance distance = new Distance(6000, Metrics.MILES);
		
		List<Book> books = repo.findByLocationCoordsNear(boston, distance);
		
		for(Book b:books){
			System.out.println(b);
		}
	}
}
