package com.dn.booksystemAPI.booksystem.Repository;

import org.springframework.data.repository.CrudRepository;

import com.dn.booksystemAPI.booksystem.Model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{}