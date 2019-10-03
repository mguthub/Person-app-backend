package com.example.person;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.person.repository.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PersonApplicationTests {

	@Autowired
    private PersonRepository personRepository;
	public void setProductRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	@Test
	public void contextLoads() {
	}

}
