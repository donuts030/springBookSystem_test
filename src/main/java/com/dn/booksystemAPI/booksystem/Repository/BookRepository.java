package com.dn.booksystemAPI.booksystem.Repository;

import org.springframework.data.repository.CrudRepository;

import com.dn.booksystemAPI.booksystem.Model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{}
