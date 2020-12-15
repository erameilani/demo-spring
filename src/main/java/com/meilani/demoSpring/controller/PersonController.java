package com.meilani.demoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meilani.demoSpring.dto.PersonDto;
import com.meilani.demoSpring.entity.PersonEntity;
import com.meilani.demoSpring.repository.PersonRepository;

@RestController
@RequestMapping("/person") // localhost:8500/person
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/get-all")
	public List<PersonEntity> getPerson() {
		List<PersonEntity> personEntities = personRepository.findAll();
//		personEntities = personRepository.findByFirstName("ajeng");
		return personEntities;
	}
	
	@GetMapping("/response-entity")
	public ResponseEntity<?> getAll() {
		List<PersonEntity> personEntities = personRepository.findAll();
		return ResponseEntity.ok(personEntities);
	}
	
	@PostMapping("/post-person")
	public ResponseEntity<?> insertPerson(@RequestBody PersonDto dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setFirstName(dto.getFirstName());
		personEntity.setLastName(dto.getLastName());
		personRepository.save(personEntity);
		return ResponseEntity.ok(personEntity);
	}
	
}
