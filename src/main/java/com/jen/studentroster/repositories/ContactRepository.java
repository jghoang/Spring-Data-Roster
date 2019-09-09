package com.jen.studentroster.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jen.studentroster.models.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{

}
