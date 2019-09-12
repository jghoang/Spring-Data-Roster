package com.jen.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jen.studentroster.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	List<Contact> findAll();
}
