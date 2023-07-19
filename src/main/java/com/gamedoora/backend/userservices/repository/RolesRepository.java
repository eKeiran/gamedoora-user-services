package com.gamedoora.backend.userservices.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamedoora.model.dao.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

	List<Roles> findByNameContaining(String name);

}
