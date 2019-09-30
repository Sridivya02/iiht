package com.demo.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.springboot.entity.Book;
import com.demo.springboot.entity.Subject;
import com.demo.springboot.service.BookService;
import com.demo.springboot.service.SubjectService;

//https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/

@Controller

public class BookController {

	@Autowired
    BookService bookSrvc;
	@Autowired
    SubjectService subSrvc;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView booksAndSubjects(Map<String, Object> model) {
		List<Book> booksList = bookSrvc.listAllBooks();
		List<Subject> subList = subSrvc.listAllSubjects();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("booksList",booksList);
		mv.addObject("subjectList",subList);
		return mv;
	}
	
	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book")Book bookObj, Map<String, Object> model, @RequestParam(value = "mode", required = false) String mode,
			@RequestParam(value = "updateBookID", required = false) Integer updateBookID, RedirectAttributes redirAttr) {
		System.out.println("Book object received mode = "+mode);
		boolean status = true;
		if("UPDATE".equalsIgnoreCase(mode)){
			bookSrvc.updateBook(bookObj, updateBookID);
		} else {
			bookSrvc.addBook(bookObj);
		}
		String msg = null;
		if(status){
			msg = "Operation completed successfully";
		} else{
			msg = "Operation failed";
		}
		redirAttr.addFlashAttribute("msg", "Book ID :"+bookObj.getBookId()+msg);
		return "redirect:/home";
	}

	@RequestMapping(value = "/addEditBookPage", method = RequestMethod.GET)
	public String addBookPage(Model model, @RequestParam(value = "bookID", required = false) Integer bookID) {
		Book book = new Book();
		if(bookID != null){
			book = bookSrvc.searchBook(bookID);
			model.addAttribute("mode","update");
			model.addAttribute("updateBookID",bookID);
		}
		model.addAttribute("book",book);
		return "addEditBook";
	}

	// delete user
	@RequestMapping(value = "/deleteBook/{bookID}", method = RequestMethod.POST)
	public String deleteBook(@PathVariable("bookID") int bookID, 
			final RedirectAttributes redirectAttributes) {
		System.out.println("DELETE BOOK in CONTROLLER--"+bookID);
		bookSrvc.deleteBookById(bookID);
		redirectAttributes.addFlashAttribute("msg", "Book is deleted! "+bookID);
		return "redirect:/home";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ModelAndView getAllBooks(Map<String, Object> model) {		
		List<Book> list = bookSrvc.listAllBooks();		
		ModelAndView mv = new ModelAndView("books");
		mv.addObject("booksList",list);

		return mv;
	}
	
	
}
