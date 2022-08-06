package com.example.Government.Government.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Government.Government.Repository.OccupationRepository;

@Service
public class OccupationService {

	@Autowired
	OccupationRepository occupationRepository;
	
}
