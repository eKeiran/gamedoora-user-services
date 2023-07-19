/**package com.gamedoora.backend.userservices.repository;

import com.gamedoora.backend.userservices.config.PropertiesConfig;
import com.gamedoora.model.dao.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@EnableConfigurationProperties(value= PropertiesConfig.class)
@TestPropertySource("classpath:test.properties")
class SampleUsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;

    private Users user;

    @BeforeEach
    public void setup(){
        user = Users.builder()
                .id(1L)
                .firstName("Test")
                .email("test@gmail.com")
                .build();
    }

    @Test
    void findUserbyId(){
//        assertThat(usersRepository).isNotNull();
//        Users users = new Users();
//        users.setId(1);

        usersRepository.save(user);

        Users userDB = usersRepository.findById(user.getId()).get();

//        Optional<Users> dummy = usersRepository.findById(1L);
//          assertNotNull(dummy);

         assertThat(userDB).isNotNull();
    }

}**/
