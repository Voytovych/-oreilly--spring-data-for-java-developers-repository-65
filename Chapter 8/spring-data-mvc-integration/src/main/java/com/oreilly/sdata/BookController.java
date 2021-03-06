package com.oreilly.sdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@Autowired
	BookRepository repository;

	@RequestMapping("/books")
	public String showBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "books";
	}

	@RequestMapping("/books/{bookId}")
	public String showBook(@PathVariable("bookId") Long bookId, Model model) {
		model.addAttribute("book", repository.findOne(bookId));
		return "book";
	}
}
