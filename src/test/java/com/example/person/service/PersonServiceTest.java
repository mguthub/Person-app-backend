package com.example.person.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {

	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllToDo(){
		List<Person> personList = Arrays.asList(new Person("Peter","Jos"),new Person("Nik","Wilaims"),new Person("Nik","Jones"),new Person("Nike","Jos"));
		when(personRepository.findAll()).thenReturn(personList);
		List<Person> result = personService.findAll();
		assertEquals(4, result.size());
	}
	
	@Test
	public void testGetPersonByFirstName(){
		List<Person> person = Arrays.asList(new Person("Becky","Williams"));
		when(personRepository.findByFirstName("Becky")).thenReturn(person);
		List<Person> result = personService.getPersonByFirstName("Becky");
		assertEquals(1, result.size());
		assertEquals("Becky", result.get(0).getFirstName());
		assertEquals("Williams", result.get(0).getLastName());
	}
	
	@Test
	public void testGetPersonByFirstNameNotFoundSizeZero(){
		List<Person> person = Arrays.asList(new Person("Becky","Williams"));
		when(personRepository.findByFirstName("Becky")).thenReturn(person);
		List<Person> result = personService.getPersonByFirstName("Beck");
		assertEquals(0, result.size());
	}
	
	@Test
	public void testGetPersonByFirstNameNotFound(){
		List<Person> person = Arrays.asList(new Person("Becky","Williams"));
		when(personRepository.findByFirstName("Becky")).thenReturn(person);
		List<Person> result = personService.getPersonByFirstName("Becky");
		assertFalse("Beck".equals(result.get(0).getFirstName()));
	}
}
