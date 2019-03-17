package com.abe.spring.abeswebsite.repositories;

import com.abe.spring.abeswebsite.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
}
