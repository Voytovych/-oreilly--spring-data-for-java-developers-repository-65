package com.oreilly.sdata;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BookUtil {

	private static String[] titles = { "Don Quixote", "1984", "Adventures of Huckleberry Finn", "Ulysses",
			"The Great Gatsby", "On The Road", "Catch 22", "To Kill A Mockingbird", "Brave New World",
			"The Scarlet Letter" };

	private static String[][] authors = { { "Ernest", "Hemmingway" }, { "Mark", "Twain" }, { "Charles", "Dickens" },
			{ "George", "Orwell" }, { "Leo", "Tolstoy" }, { "Mark", "Twain" }, { "Oscar", "Wilde" },
			{ "John", "Steinbeck" } };

	private static String[] countries = { "United States", "Cuba", "Australia", "Russia", "Canda" };

	private static String[] tags = { "Classic", "Novel", "Best Seller", "Must Read" };

	public static List<Book> create(int size) {
		List<Book> books = new LinkedList<Book>();
		for (int x = 0; x < size; x++) {
			books.add(BookUtil.create());
		}
		return books;
	}

	public static Book create() {
		Book book = new Book();
		book.setTitle(titles[ThreadLocalRandom.current().nextInt(1, titles.length - 1)]);
		book.setPageCount(ThreadLocalRandom.current().nextInt(100, 151));
		book.setPublishDate(new Date());
		book.setPrice(new BigDecimal("15.00"));
		Author author = new Author();
		String[] tmpAuthor = authors[ThreadLocalRandom.current().nextInt(1, authors.length - 1)];
		author.setFirstName(tmpAuthor[0]);
		author.setLastName(tmpAuthor[1]);
		author.setCountry(countries[ThreadLocalRandom.current().nextInt(1, countries.length - 1)]);
		book.setAuthor(author);
		book.getTags().add(tags[ThreadLocalRandom.current().nextInt(1, countries.length - 1)]);
		return book;
	}

}