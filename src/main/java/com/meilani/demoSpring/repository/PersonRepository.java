package com.meilani.demoSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meilani.demoSpring.entity.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
	@Query(value = "select * from person_entity where first_name = ?", nativeQuery = true)
	List<PersonEntity> findByFirstName(String firstName);
}
