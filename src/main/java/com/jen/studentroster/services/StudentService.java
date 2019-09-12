package com.jen.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jen.studentroster.models.Contact;
import com.jen.studentroster.models.Student;
import com.jen.studentroster.repositories.ContactRepository;
import com.jen.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentRepo;
	private ContactRepository contactRepo;
	
	public StudentService(StudentRepository studentRepo, ContactRepository contactRepo) {
		this.studentRepo = studentRepo;
		this.contactRepo = contactRepo;
	}
	
	public List<Student> getStudents(){
		return studentRepo.findAll();
	}
	
	public Student findStudent(Long id) {
		// Optional allows for null
				Optional<Student> optionalStudent = studentRepo.findById(id);
				if(optionalStudent.isPresent()) {
					return optionalStudent.get();
				} else {
					return null;
				}
	}
	public Contact createContact(Contact c) {
		
		return contactRepo.save(c);
		
			
	}
	public Student createStudent(Student s) {
		return studentRepo.save(s);
	}
}
