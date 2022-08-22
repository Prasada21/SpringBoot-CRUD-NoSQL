package com.prasad.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prasad.springbootmongodb.model.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}