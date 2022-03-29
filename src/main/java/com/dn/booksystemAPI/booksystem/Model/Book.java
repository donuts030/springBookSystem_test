package com.dn.booksystemAPI.booksystem.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private String price;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors = new ArrayList<>();
  
    public Long getId() {
      return id;
    }
  
    public void setId(Long id) {
      this.id = id;
    }
  
    public String getTitle() {
      return title;
    }
  
    public void setTitle(String title) {
      this.title = title;
    }


    public String getPrice() {
        return price;
      }
    
      public void setPrice(String price) {
        this.price = price;
      }

    public List<Author> getAuthors(){
        return authors;
    }

    public void setAuthors(List<Author> authors){
        this.authors = authors;
    }

/*     public void addAuthor(Author author){
        this.authors.add(author);
    } */
}
