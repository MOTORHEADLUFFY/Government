package com.example.Government.Government.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Occupation {

	@Id
	Integer id;
	
	@Column(name = "AVERAGE_SALARY")
	Integer averageSalary;
	
	@Column(name = "NAME")
	String name;
}
