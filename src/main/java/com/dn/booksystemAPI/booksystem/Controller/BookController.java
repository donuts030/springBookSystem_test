package com.dn.booksystemAPI.booksystem.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dn.booksystemAPI.booksystem.Model.Author;
import com.dn.booksystemAPI.booksystem.Model.Book;
import com.dn.booksystemAPI.booksystem.Repository.AuthorRepository;
import com.dn.booksystemAPI.booksystem.Repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping(path="/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(books::add);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping(path="/addbooks")
    public ResponseEntity<Book> createAuthor(@RequestBody Book book){
        Book B = new Book();
        B.setTitle(book.getTitle());
        B.setPrice(book.getPrice());
        Book _book = bookRepository.save(B);

        return new ResponseEntity<>(_book, HttpStatus.CREATED);
    }


    @PostMapping(path="/authors/{authorId}/books")
    public ResponseEntity<Book> addBookToAuthor(@PathVariable(value = "authorId") Long authorId, @RequestBody Book bookReq){
        Optional<Author> A = authorRepository.findById(authorId);
        /* Book resBook;
        String errMessage ="";
 */
        A.ifPresent(author ->{
            long bookId = bookReq.getId();
            
            Optional<Book> _book = bookRepository.findById(bookId);
/*             resBook =_book.ifPresent(book ->{
                author.addBook(book);
                return book;
            }); */
            

            if (!_book.isPresent()){
                bookRepository.save(bookReq);
            }
            author.addBook(bookReq);
            authorRepository.save(author);
        });

        if(!A.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(bookReq, HttpStatus.OK); 
            
       
    }

    
}