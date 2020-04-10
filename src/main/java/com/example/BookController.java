package com.example;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	private String randomString() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	
	    return generatedString;
	}
	
	@GetMapping("/api/books")
	public List<Book> getBooks(@RequestParam(required = false) Integer add) {
		if(add != null && add > 0) {
			add = add > 5 ? 5 : add; // max add 5
			for(int i = 0; i < add; i++) {
				Book book = new Book();
				book.setName(randomString() + "-" + randomString());
				bookRepository.save(book);
			}
		}
		return bookRepository.findAll();
	}
}
