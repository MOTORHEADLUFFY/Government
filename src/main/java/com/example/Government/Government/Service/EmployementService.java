package com.example.Government.Government.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Government.Government.Entity.Employement;
import com.example.Government.Government.Repository.EmployementRepository;

@Service
public class EmployementService {

	@Autowired
	EmployementRepository employementRepository;
	
	public List<Employement> fetchEveryoneWithThisJob(Integer occupationId){
		return employementRepository.findByOccupationId(occupationId);
		
	}
}
