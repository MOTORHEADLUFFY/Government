package com.example.Government.Government.Controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Government.Government.DAO.SalaryResponse;
import com.example.Government.Government.Entity.Person;
import com.example.Government.Government.Service.PersonService;

import lombok.SneakyThrows;

@RequestMapping("person")
@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@SneakyThrows
	@GetMapping("fetchEveryone")
	public List<Person> fetchEveryone(){
		CompletableFuture<List<Person>> future = CompletableFuture.supplyAsync(() -> personService.fetchEveryone());
		return future.get();
	
	}
	
	@GetMapping("fetchAverageSalaryOfThisJob/{occupationId}")
	public Double fetchAverageSalaryOfThisJob(@PathVariable Integer occupationId) {
		return personService.fetchAverageSalaryOfThisJob(occupationId);
	}
	
	@GetMapping("salaryChart")
	public List<SalaryResponse> fetchSalaryChart(){
		return personService.fetchSalaryChart();
	}
	
	@GetMapping("fetchFamilyTree/{personId}")
	public List<Person> fetchFamilyTree(@PathVariable String personId){
		return personService.fetchFamilyTree(personId);
	}
}
