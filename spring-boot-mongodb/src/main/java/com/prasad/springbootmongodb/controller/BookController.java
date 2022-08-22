package com.prasad.springbootmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.prasad.springbootmongodb.model.Book;
import com.prasad.springbootmongodb.service.BookService;

@RestController
@RequestMapping("/Books")
public class BookController {
	@Autowired
	BookService bookservice;
	
	
	@PostMapping("/savebook")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
	return new ResponseEntity<Book>(bookservice.addBook(book),HttpStatus.CREATED);

}
	
	@GetMapping("/getall")
	public List<Book> getAll(){
		return bookservice.getAll();
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Book> findByid(@PathVariable("id") Integer bookId){
		return new ResponseEntity<Book>(bookservice.findById(bookId),HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Integer bookId
			  ,@RequestBody Book book){
     return new ResponseEntity<Book>(bookservice.updateBook(book, bookId), HttpStatus.OK);
     }
	
	
	
	@DeleteMapping("deelete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Integer bookId){
		bookservice.deleteBook(bookId);
		return new ResponseEntity<String>("Book deleted successfully!.", HttpStatus.OK); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
