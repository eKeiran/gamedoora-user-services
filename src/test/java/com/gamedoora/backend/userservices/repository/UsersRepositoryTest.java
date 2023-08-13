
package com.gamedoora.backend.userservices.repository;

import com.gamedoora.backend.userservices.config.PropertiesConfig;
import com.gamedoora.model.dao.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
@DataJpaTest(properties = {"spring.cloud.config.enabled=false"})
// @EnableConfigurationProperties(value= PropertiesConfig.class)
// @TestPropertySource("classpath:test.properties")

class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;
    private Users user;
    private UserRole userRole;
    private Roles role;
    private UserSkills userSkills;
    private Skills skill;

    @BeforeEach
    void setup() {
        role = Roles.builder().id(1L).build();
        skill = Skills.builder().id(1L).build();
        userRole = UserRole.builder().roles(role).build();
        userSkills = UserSkills.builder().skills(skill).build();

        Set<UserRole> userRoleSet = new HashSet<>();
        userRoleSet.add(userRole);

        Set<UserSkills> userSkillsSet = new HashSet<>();
        userSkillsSet.add(userSkills);

        user = Users.builder()
                .id(1L)
                .firstName("Test")
                .email("test@gmail.com")
                .userRole(userRoleSet)
                .userSkills(userSkillsSet)
                .providerToken("validProviderToken") // Set a valid provider token here can't be null
                .build();
    }
   @Test
    void findByFirstName() {
       usersRepository.save(user);
       Users userValue = usersRepository.findByFirstName(user.getFirstName());
       assertThat(userValue).isNotNull();
       assertThat(userValue.getFirstName()).isEqualTo("Test");
    }

    @Test
    void findByRole() {
        usersRepository.save(user);
        Users userValue = usersRepository.findByUserRole(userRole.getRoles());
        assertThat(userValue).isNotNull();
        assertThat(userValue.getUserRole()).isEqualTo(userRole);
    }

    @Test
    void findBySkill() {
        usersRepository.save(user);
        Users userValue = usersRepository.findByUserSkills(userSkills.getSkills());
        assertThat(userValue).isNotNull();
        assertThat(userValue.getUserSkills()).isEqualTo(userSkills);
    }

    @Test
    void findUserRolesBySkill_SkillsId() {
        usersRepository.save(user);
        List<UserRole> userRoleList = usersRepository.findUserRolesByUserSkills_SkillsId(skill.getId());
        assertFalse(userRoleList.isEmpty());
    }

    @Test
    void findUsersBySkill_SkillsId() {
        usersRepository.save(user);
        List<Users> userSkillsList = usersRepository.findByUserSkills_SkillsId(skill.getId());
        assertFalse(userSkillsList.isEmpty());
    }
}

