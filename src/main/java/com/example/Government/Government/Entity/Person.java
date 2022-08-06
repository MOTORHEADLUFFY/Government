package com.example.Government.Government.Entity;

import javax.persistence.*;
import com.example.Government.Government.DAO.Gender;

import lombok.Data;

@Data
@Entity
public class Person {
	
	@Id
	String id;
	
	@Column(name = "FIRST_NAME")
	String firstName;
	
	@Column(name = "LAST_NAME")
	String lastName;
	
	@Column(name = "AGE")
	Integer age;
	
	@Column(name = "SALARY")
	Integer salary;
	
	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	Gender Gender;
	
	@Column(name = "PARENT_ID_1")
	String parentId1;
	
	@Column(name = "PARENT_ID_2")
	String parentId2;
	
}
