package com.project.library_database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.library_database.dao.BookRepository;
import com.project.library_database.entity.Book;

@Service
public class BookService implements ServiceMethods {
	
	@Autowired
	private BookRepository bookRepo;

	public void save(Book book) {
		// TODO Auto-generated method stub
		bookRepo.save(book);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		
	Optional<Book> result = bookRepo.findById(id);
		
		Book book = null;
		if(result.isPresent()) {
			book = result.get();
		} else {
			throw new RuntimeException("Did not find book id - " + id);
		}
		
		return book;
		
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(id);
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}
