package com.demo.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springboot.entity.Book;
import com.demo.springboot.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
    BookRepository bookRepo;
	
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	public Book searchBook(long bookID) {
		return bookRepo.getOne(bookID);
	}
	public List<Book> listAllBooks() {
		return bookRepo.findAll();
	}
	public void updateBook(Book book, long bookID) {
		boolean isPresent = bookRepo.existsById(bookID);
		if(isPresent){
			deleteBookById(bookID);
			bookRepo.save(book);
		}
	}
	public void deleteBookById(long bookID) {
		bookRepo.deleteById(bookID);
	}
	public void deleteAllBooks() {
		bookRepo.deleteAll();
	}
}
