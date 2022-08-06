package com.example.Government.Government.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Government.Government.DAO.SalaryResponse;
import com.example.Government.Government.Entity.Person;
import com.example.Government.Government.Repository.PersonRepository;

import lombok.SneakyThrows;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	EmployementService employementService;
	
	public List<Person> fetchEveryone() {
		return personRepository.findAll();
	}
	
	public List<Person> fetchPeopleOfTheseIds(List<String> ids) {
		List<Person> people =  personRepository.findAllById(ids);
		 people.stream().forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
		return people;
	}

	@SneakyThrows
	public Double fetchAverageSalaryOfThisJob(Integer occupationId) {
		
		 CompletableFuture<Double> future =  CompletableFuture.supplyAsync(() -> employementService.fetchEveryoneWithThisJob(occupationId))
	.thenApply( employement -> {
			List<String> Ids = employement.stream().map(a -> a.getPersonId()).toList();
			return fetchPeopleOfTheseIds(Ids);
	}).thenCompose(people -> (
			CompletableFuture.supplyAsync(() -> (people.stream().map( s -> s.getSalary()).mapToDouble(s -> s).average().orElse(0.0)))
			));
		 
		 return future.get();
	}
	
	
	public List<SalaryResponse> fetchSalaryChart(){
		return personRepository.findAll().stream().sorted((a, b) -> (b.getSalary().compareTo(a.getSalary()))).map( p -> new SalaryResponse(p.getFirstName() + " " + p.getLastName(), p.getSalary())).toList();
	}

	public List<Person> fetchFamilyTree(String personId) {
		List<Person> familyTree = new ArrayList<>();
		constructFamilyTree(personId, familyTree);
		return familyTree;
	}

	@SneakyThrows
	private void constructFamilyTree(String personId, List<Person> familyTree) {
		CompletableFuture<List<Person>> future1 = CompletableFuture.supplyAsync(() -> personRepository.findByParentId1(personId)); 
		CompletableFuture<List<Person>> future2 = CompletableFuture.supplyAsync(() -> personRepository.findByParentId2(personId));
		
		CompletableFuture.allOf(future1, future2);
		
		List<Person> nextGeneration1 = future1.get();
		List<Person> nextGeneration2 = future2.get();
		
		nextGeneration2.removeAll(nextGeneration1);
		nextGeneration1.addAll(nextGeneration2);
		
		if(!nextGeneration1.isEmpty()) {
			nextGeneration1.forEach( person -> {
				familyTree.add(person);
				constructFamilyTree(person.getId(), familyTree);
			});
		}
	}
}
