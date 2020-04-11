package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDbExampleApplicationTests {
	@Autowired
	private BookService bookService;

	@Test
	void contextLoads() {
	}

	@Test
	void validate() {
		assertEquals(10, bookService.count(), "Yay");
	}
}
