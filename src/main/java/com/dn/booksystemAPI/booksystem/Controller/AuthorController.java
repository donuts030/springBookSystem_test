package com.dn.booksystemAPI.booksystem.Controller;

import com.dn.booksystemAPI.booksystem.Repository.AuthorRepository;
import com.dn.booksystemAPI.booksystem.Model.Author;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping(path="/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = new ArrayList<Author>();
        authorRepository.findAll().forEach(authors::add);;
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping(path="/addauthors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author A = new Author();
        A.setAuthorName(author.getAuthorName());
        Author _author = authorRepository.save(A);

        return new ResponseEntity<>(_author, HttpStatus.CREATED);
    }
}
