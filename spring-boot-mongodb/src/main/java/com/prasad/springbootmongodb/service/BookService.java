package com.prasad.springbootmongodb.service;

import java.util.List;

import com.prasad.springbootmongodb.model.Book;

public interface BookService {
	Book addBook(Book book);
	List<Book> getAll();
    Book findById(int bookId);
	Book  updateBook(Book book,int bookId);
	void deleteBook(int bookid);
	

}
