package com.example.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.person.model.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, String>{
	
	public List<Person> findByFirstName(String fname);
}
