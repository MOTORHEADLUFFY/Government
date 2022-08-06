package com.example.Government.Government.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Entity
@Data
@IdClass(EmployementPK.class)
public class Employement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PERSON_ID")
	String personId; 
	
	@Id
	@Column(name = "JOB_ID")
	Integer jobId;
	
	@Id
	@Column(name = "OCCUPATION_ID")
	Integer occupationId;
}
