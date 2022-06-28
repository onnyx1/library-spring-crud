package com.project.library_database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.library_database.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

	public List<Book> findAllByOrderByAuthor();

}
