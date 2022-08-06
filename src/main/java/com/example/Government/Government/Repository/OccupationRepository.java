package com.example.Government.Government.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Government.Government.Entity.Occupation;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation, Integer>{


}
