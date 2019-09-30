package com.demo.springboot.controller;

import java.util.HashSet;
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
public class SubjectController {

	@Autowired
	private SubjectService subjectSrvc;	
	@Autowired
	private BookService bookSrvc;	

	@RequestMapping(value = "/saveSubject", method = RequestMethod.POST)
	public String addSubject(@ModelAttribute("subject")Subject subjectObj, Map<String, Object> model, @RequestParam(value = "mode", required = false) String mode,
			@RequestParam(value = "updateSubjectID", required = false) Integer updateSubjectID, RedirectAttributes redirAttr) {
		System.out.println("Book object received mode = "+mode);
		boolean status = true;
		if("UPDATE".equalsIgnoreCase(mode)){
			subjectSrvc.updateSubject(subjectObj, updateSubjectID);
		} else {
			subjectSrvc.addSubject(subjectObj);
		}
		String msg = null;
		if(status){
			msg = "Operation completed successfully";
		} else{
			msg = "Operation failed";
		}
		redirAttr.addFlashAttribute("msg", "Book ID :"+subjectObj.getSubjectId()+msg);
		return "redirect:/home";
	}

	@RequestMapping(value = "/addEditSubjectPage", method = RequestMethod.GET)
	public String addBookPage(Model model, @RequestParam(value = "subjectID", required = false) Integer subjectID) {
		Subject subject = new Subject();
		List<Book> books = bookSrvc.listAllBooks();
		HashSet<Book> booksSet = new HashSet<Book>(books);
		subject.setReferences(booksSet);
		if(subjectID != null){
			subject = subjectSrvc.searchSubject(subjectID);
			model.addAttribute("mode","update");
			model.addAttribute("updateSubjectID",subjectID);
		}
		model.addAttribute("subject",subject);
		model.addAttribute("bookSet", booksSet);
		return "addEditSubject";
	}

	@RequestMapping(value = "/deleteSubject/{subjectID}", method = RequestMethod.POST)
	public String deleteBook(@PathVariable("subjectID") int subjectID, 
			final RedirectAttributes redirectAttributes) {
		System.out.println("DELETE BOOK in CONTROLLER--"+subjectID);
		subjectSrvc.deleteSubjectById(subjectID);
		redirectAttributes.addFlashAttribute("msg", "Subject is deleted! "+subjectID);
		return "redirect:/home";
	}

	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public ModelAndView getAllSubjects(Map<String, Object> model) {		
		List<Subject> list = subjectSrvc.listAllSubjects();		
		ModelAndView mv = new ModelAndView("subjects");
		mv.addObject("subjectsList",list);

		return mv;
	}
}
