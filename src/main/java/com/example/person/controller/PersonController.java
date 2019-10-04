package com.example.person.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.person.model.Person;
import com.example.person.service.PersonService;


@RestController
@RequestMapping(path = "/api/persons")
public class PersonController {
	private Logger LOG = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	private PersonService personService;
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE,PUT");
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity <List<Person>> getPersonByFirstName(@RequestParam("firstName") String firstName){
		LOG.info("Firstname of person to search for is {}",firstName);
		if(Optional.ofNullable(firstName).isPresent())
			return new ResponseEntity<>(
					personService.getPersonByFirstName(firstName), 
				      HttpStatus.OK);
			//return personService.getPersonByFirstName(firstName);
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET,path={"/searchAll"})
	public List<Person> findAll(){
		return personService.findAll();
	}
}
