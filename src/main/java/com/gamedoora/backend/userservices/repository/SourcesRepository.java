package com.gamedoora.backend.userservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamedoora.model.dao.Sources;

@Repository
public interface SourcesRepository extends JpaRepository<Sources, Long> {

	List<Sources> findByNameContaining(String name);
}
