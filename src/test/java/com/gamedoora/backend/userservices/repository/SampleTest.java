/**package com.gamedoora.backend.userservices.repository;


import com.gamedoora.backend.userservices.assembler.UserServicesAssembler;
import com.gamedoora.model.dto.UserDTO;
import com.gamedoora.model.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SampleTest {
    @Mock
    private UsersRepository usersRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServicesAssembler userServicesAssembler;

    @Test
    public void sampleTest(){
        UserDTO user = new UserDTO();
        user.setFirstName("Test");


//        when(usersRepository.findById(1L)).thenReturn(user);
        UserDTO dummy = userServicesAssembler.createUsers(user);


        assertNotNull(dummy);
        assertEquals(dummy.getFirstName(), user.getFirstName());
    }
}**/
