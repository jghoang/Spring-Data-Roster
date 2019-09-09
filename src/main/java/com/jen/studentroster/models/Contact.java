package com.jen.studentroster.models;

import javax.persistence.*  ;

@Entity
@Table(name="contacts")
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String address;
	private String city;
	private String state;

}
