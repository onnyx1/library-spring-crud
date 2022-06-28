package com.project.library_database.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.library_database.entity.Book;
import com.project.library_database.service.BookService;
import com.project.library_database.service.CSVService;

@Controller
@RequestMapping("/library")
public class LibraryController {
	@Autowired
	private BookService bookService;
	@Autowired
	private CSVService csvService;

	@GetMapping("/home")
	public String showLibraryHome(Model model) {

		List<Book> catalog = bookService.findAll();
		model.addAttribute("books", catalog);

		return "library-home";
	}

	@GetMapping("/delete")
	public String deleteBook(@RequestParam("bookId") int id) {

		bookService.delete(id);

		return "redirect:/library/home";

	}

	@GetMapping("/update")
	public String updateBook(@RequestParam("bookId") int id, Model model) {

		Book book = bookService.findById(id);
		model.addAttribute("book", book);

		return "updateForm";

	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("title") String title, @RequestParam("author") String author,
			@RequestParam("publisher") String publisher, @RequestParam("pages") int pages,
			@RequestParam("genre") String genre) {
		Book book = new Book();
		book.setId(0);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setGenre(genre);
		book.setNumber_of_pages(pages);
		bookService.save(book);
		return "redirect:/library/home";
	}

	@PostMapping("/update")
	public String updateBook(@RequestParam("id") int id, @RequestParam("title") String title,
			@RequestParam("author") String author, @RequestParam("publisher") String publisher,
			@RequestParam("pages") int pages, @RequestParam("genre") String genre) {

		Book book = bookService.findById(id);
		book.setTitle(title);
		book.setAuthor(author);
		book.setPublisher(publisher);
		book.setGenre(genre);
		book.setNumber_of_pages(pages);
		bookService.save(book);
		return "redirect:/library/home";
	}

	@GetMapping(path = "/csv")
	public void getAllEmployeesInCsv(HttpServletResponse servletResponse) {
		servletResponse.setContentType("text/csv");
		servletResponse.addHeader("Content-Disposition", "attachment; filename=\"library.csv\"");
		try {
			csvService.writeBooksToCsv(servletResponse.getWriter());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
