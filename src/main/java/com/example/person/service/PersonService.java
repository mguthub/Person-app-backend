package com.example.person.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;

@Service 
public class PersonService {
	
	private Logger LOG = LoggerFactory.getLogger(PersonService.class);
	
	private PersonRepository personRepository;

	@Autowired
	public void setProductRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> getPersonByFirstName(String firstName){
		List<Person> personFNameList = new ArrayList<Person>(); 
		try {
			personRepository.findByFirstName(firstName).forEach(personFNameList::add);
		} catch (Exception ex) {
			LOG.error("Exception Occured {} and error is,"+ ex);
		}
		return personFNameList;
	}

	public List<Person> findAll(){
		List<Person> personNameList = new ArrayList<Person>(); 
		try {
			personRepository.findAll().forEach(personNameList::add);
		} catch (Exception e) {
			LOG.error("Exception Occured {} and error is,"+ e);
			e.printStackTrace();
		}
		return personNameList;
	}
}


