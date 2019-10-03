package com.example.person.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.person.PersonApplication;
import com.example.person.repository.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersonApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersonRestControllerIntegrationTest {
	
    private MockMvc mockMvc;
 
    @Autowired
    private WebApplicationContext wac;
    
    @Autowired
    private PersonRepository personRepository;

	public void setProductRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void verifyfindAllList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/persons/searchAll").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(7))).andDo(print());
	}
	
	@Test
	public void verifyByFirstName() throws Exception {
		String name="Nik";
		mockMvc.perform(MockMvcRequestBuilders.get("/api/persons").param("firstName", name).accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].firstName").exists())
		.andExpect(jsonPath("$[0].lastName").exists())  
		.andExpect(jsonPath("$[1].firstName").exists())
		.andExpect(jsonPath("$[1].lastName").exists())  
		.andDo(print());
	}

	@Test
	public void verifyInvalidURL() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/persons/f").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound())
			.andDo(print());
	}
}
