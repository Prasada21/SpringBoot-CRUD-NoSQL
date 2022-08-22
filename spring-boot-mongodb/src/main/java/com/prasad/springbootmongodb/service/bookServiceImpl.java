package com.prasad.springbootmongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.springbootmongodb.exception.ResourceNotFoundException;
import com.prasad.springbootmongodb.model.Book;
import com.prasad.springbootmongodb.repository.BookRepository;

@Service
public class bookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookrepository;

	@Override
	public Book addBook(Book book) {
		return bookrepository.save(book);
	}

	@Override
	public List<Book> getAll() {
		return bookrepository.findAll();
	}

	@Override
	public Book findById(int bookId) {
		Optional<Book> bookOpt=bookrepository.findById(bookId);
		if(bookOpt.isPresent())
			return bookOpt.get();
		return null;
	}

	@Override
	public Book updateBook(Book book,int bookId) {
	Book existingbook=bookrepository.findById(bookId).orElseThrow(
			() -> new ResourceNotFoundException("Book", "Id", bookId));
	
		existingbook.setTitle(existingbook.getTitle());
		existingbook.setAuthor(existingbook.getAuthor());
		existingbook.setCategory(existingbook.getCategory());
		existingbook.setCost(existingbook.getCost());
		bookrepository.save(existingbook);
		return existingbook;
	}

	@Override
	public void deleteBook(int bookid) {
		bookrepository.deleteById(bookid);
		
	}

	

}
