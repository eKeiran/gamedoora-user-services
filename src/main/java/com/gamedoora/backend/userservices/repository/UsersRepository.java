package com.gamedoora.backend.userservices.repository;
import javax.persistence.Query;

import java.util.List;

import com.gamedoora.model.dao.Roles;
import com.gamedoora.model.dao.UserRole;
import com.gamedoora.model.dao.Skills;

import com.gamedoora.model.dao.UserSkills;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.gamedoora.model.dao.Users;

@Repository
//@EntityScan("com.gamedoora.model.dao.*")
public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findByEmailContaining(String email);

	Users findByFirstName(String firstName);
	Users findByLastName(String lastName);
	Users findByUserRole(Roles role);

	Users findByUserSkills(Skills skill);

	List<UserRole> findUserRolesByUserSkills_SkillsId(Long skillsId);
	// multiple roles with one skill

	List<Users> findByUserSkills_SkillsId(Long skillsId);

}
