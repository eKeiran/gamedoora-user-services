
package com.gamedoora.backend.userservices.repository;

import com.gamedoora.backend.userservices.config.PropertiesConfig;
import com.gamedoora.model.dao.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;


@DataJpaTest
@EnableConfigurationProperties(value= PropertiesConfig.class)
@TestPropertySource("classpath:test.properties")
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    private Users user;
    private UserRole userRole;
    private Roles role;
    private UserSkills userSkills;

    private Skills skill;

    @BeforeEach
    void setup(){

        skill = Skills.builder().id(1L).build();
        userRole = UserRole.builder().roles(role).build();
        userSkills = UserSkills.builder().skills(skill).build();
        role = Roles.builder().id(1L).build();


        user = Users.builder()
                .id(1L)
                .firstName("Test")
                .email("test@gmail.com")
                .userRole((Set<UserRole>) userRole)
                .userSkills((Set<UserSkills>) userSkills)
                .build();
    }

   @Test
    void findByName() {
       usersRepository.save(user);
       Users userValue = usersRepository.findByName(user.getFirstName());
       assertThat(userValue).isNotNull();
       assertThat(userValue.getFirstName()).isEqualTo("Test");
    }

   @Test
    void findByRole() {
       usersRepository.save(user);
       Users userValue = usersRepository.findByRole((UserRole) user.getUserRole());
       assertThat(userValue).isNotNull();
       assertThat(userValue.getUserRole()).isEqualTo(userRole);
    }

    @Test
    void findBySkill() {
        usersRepository.save(user);
        Users userValue = usersRepository.findBySkill((UserSkills) user.getUserSkills());
        assertThat(userValue).isNotNull();
        assertThat(userValue.getUserSkills()).isEqualTo(userSkills);
    }

    @Test
    void findRolesBySkill_SkillsId() {
        usersRepository.save(user);
        List<UserRole> userRoleList = usersRepository.findRolesBySkill_SkillsId(skill.getId());
        assertFalse(userRoleList.isEmpty());
    }

    @Test
    void listUsersBySkill_SkillsId() {
        usersRepository.save(user);
        List<Users> userSkillsList = usersRepository.listUsersBySkill_SkillsId(skill.getId());
        assertFalse(userSkillsList.isEmpty());
    }
}

