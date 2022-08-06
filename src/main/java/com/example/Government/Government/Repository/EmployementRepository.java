package com.example.Government.Government.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Government.Government.Entity.Employement;

@Repository
public interface EmployementRepository extends JpaRepository<Employement, Employement>{

	List<Employement> findByJobId(Integer jobId);

	List<Employement> findByOccupationId(Integer jobId);

}
