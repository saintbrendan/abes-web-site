package com.abe.spring.abeswebsite.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String isbn;
  private String publisher;

  @ManyToMany
  @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
          inverseJoinColumns = @JoinColumn(name = "author_id"))
  private Set<Author> authors = new HashSet<>();

  public Book(String title, String isbn, String publisher) {
    this.title = title;
    this.isbn = isbn;
    this.publisher = publisher;
  }

  public Book(String title, String isbn, String publisher, Set<Author> authors) {
    this.title = title;
    this.isbn = isbn;
    this.publisher = publisher;
    this.authors = authors;
  }

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

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  @Override
  public boolean equals(final Object o){
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;
    final Book book = (Book)o;
    return Objects.equals(id, book.id);
  }

  @Override
  public int hashCode(){
    return Objects.hash(id);
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  @Override
  public String toString(){
    return "Book{" + "id=" + id + ", title='" + title + '\'' + ", isbn='" + isbn + '\'' + ", publisher='" + publisher + '\'' + ", authors=" + authors + '}';
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }
}
