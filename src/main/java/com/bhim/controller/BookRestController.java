package com.bhim.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhim.binding.Book;

@RestController
public class BookRestController {

	@GetMapping("/book")
	public Book getBookData() {
		Book book = new Book(101, "yugantam", 450.0);
		return book;
	}
}
