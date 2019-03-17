package com.abe.spring.abeswebsite.repositories;

import com.abe.spring.abeswebsite.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
