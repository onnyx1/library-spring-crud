package com.project.library_database.service;

import java.util.List;

import com.project.library_database.entity.Book;

public interface ServiceMethods {

	public void save(Book book);
	public List<Book> findAll();
	public Book findById(int id);
	public void delete(int id);
	public void update(int id);
	
	
	
}
