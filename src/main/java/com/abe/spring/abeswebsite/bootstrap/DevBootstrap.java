package com.abe.spring.abeswebsite.bootstrap;

import com.abe.spring.abeswebsite.model.Author;
import com.abe.spring.abeswebsite.model.Book;
import com.abe.spring.abeswebsite.model.Publisher;
import com.abe.spring.abeswebsite.repositories.AuthorRepository;
import com.abe.spring.abeswebsite.repositories.BookRepository;
import com.abe.spring.abeswebsite.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;

  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData(){
    // Harper Collins
    Publisher harperCollins = new Publisher("Harper Collins", "195 Broadway");
    Publisher simonSchuster = new Publisher("Simon & Schuster", "1230 6th Ave");
    publisherRepository.save(harperCollins);
    publisherRepository.save(simonSchuster);

    //Eric
    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);


    //Rod
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "23444", simonSchuster );
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    authorRepository.save(rod);
    bookRepository.save(noEJB);

  }
}
