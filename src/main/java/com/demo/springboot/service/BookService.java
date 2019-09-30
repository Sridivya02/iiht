package com.demo.springboot.service;

import java.util.List;

import com.demo.springboot.entity.Book;

public interface BookService {

	public Book addBook(Book book);
	public Book searchBook(long bookID);
	public List<Book> listAllBooks();
	public void updateBook(Book book, long bookID);
	public void deleteBookById(long bookID);
	public void deleteAllBooks();
	
}
