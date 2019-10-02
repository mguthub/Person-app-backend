package com.example.person;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;

@SpringBootApplication
public class PersonApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;
	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> personList = Arrays.asList(new Person("Peter","Jos"),new Person("Nik","Wilaims"),new Person("Nik","Jones"),new Person("Nike","Jos"),new Person("Bob","Marley"),new Person("Peter","North"),new Person("Bianaca","Andrescue"));
		personRepository.saveAll(personList);
	}
}
