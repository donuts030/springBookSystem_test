package com.dn.booksystemAPI.booksystem.Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;


@Entity
public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String authorName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name ="book_author",
        joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "author_id",
        referencedColumnName = "id"))
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books){
        this.books = books;
    }

    public void addBook(Book book){
        this.books.add(book);
        book.getAuthors().add(this);
    }

    
}
