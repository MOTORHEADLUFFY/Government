package com.example.Government.Government.Repository;


import org.springframework.stereotype.Repository;
import com.example.Government.Government.Entity.Person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PersonRepository extends JpaRepository<Person, String>{

	List<Person> findByParentId1(String personId);
	
	List<Person> findByParentId2(String personId);
	
}
