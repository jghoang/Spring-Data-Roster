package com.jen.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jen.studentroster.models.Contact;
import com.jen.studentroster.models.Student;
import com.jen.studentroster.services.StudentService;

@Controller
public class HomeController {
	// Dependency injection
	private final StudentService studentService;

	// Constructors
	public HomeController(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/")
	public String Index(Model model) {
		model.addAttribute("students", studentService.getStudents());
		return "index.jsp";
	}
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newStudent(@ModelAttribute("student") Student student) {
		return "new.jsp";
	}
	@RequestMapping(value="new", method=RequestMethod.POST)
	// The @Valid annotation checks to see if the submitted object passed validation
	// @BindingResult must come immediately after the @Valid annotation parameter. This tells the application to check for errors!
	public String addNewPerson(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		// Event handler for error checking
		if (result.hasErrors()) {
			return "new.jsp"; 
		} else {
			studentService.createStudent(student);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
		List<Student> studs = studentService.getStudents();
		model.addAttribute("students", studs);
		return "contact.jsp";
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public String createContact(@Valid @ModelAttribute("contact") Contact contact, BindingResult result) {
		if (result.hasErrors())
			return "contact.jsp";
		studentService.createContact(contact);
		return "redirect:/";
	}
}
