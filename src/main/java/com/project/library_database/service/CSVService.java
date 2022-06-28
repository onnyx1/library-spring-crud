package com.project.library_database.service;

import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.library_database.dao.BookRepository;
import com.project.library_database.entity.Book;

@Service
public class CSVService {

	@Autowired
	private BookRepository bookRepo;


    public void writeBooksToCsv(Writer writer) {

        List<Book> books = bookRepo.findAll();
        try (CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
        	printer.printRecord("Title","Author","Publisher","Genre","Number of Pages");
            for (Book book : books) {
                printer.printRecord(book.getTitle(),book.getAuthor(),book.getPublisher(),book.getGenre(),book.getNumber_of_pages());
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
}
	

