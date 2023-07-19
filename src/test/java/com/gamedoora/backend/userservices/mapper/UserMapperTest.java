//package com.gamedoora.backend.userservices.mapper;
//
//import com.gamedoora.model.dto.UserDTO;
//import com.gamedoora.model.dao.Roles;
//import com.gamedoora.model.dao.Skills;
//import com.gamedoora.model.dao.UserRole;
//import com.gamedoora.model.dao.UserSkills;
//import com.gamedoora.model.dao.Users;
//import com.gamedoora.model.mapper.UserMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mapstruct.factory.Mappers;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//import java.util.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
///**
// observation, injectible mapper is not working, will se that as well,
// but assertEquals(testUserSkillsList.get(0) , userSkills1);
// assertEquals(testUserRoleList.get(1) , userRole2); gives:
//
// org.opentest4j.AssertionFailedError:
// Expected :com.gamedoora.model.dao.UserSkills@6b98a075
// Actual   :com.gamedoora.model.dao.UserSkills@2e61d218
//
// this object is returning its own uniqueId, and since this can vary its throwing error,
// changing it to a specific property solves the problem but object ID might change, so it will
// throw an error.
//
// Also, spring works on multiple VMs, that is why having toString() based on some toHash() gives
// different value for each iteration.
//
// //    @Autowired
// //    private UserMapper userMapper;
// **/
//
//@ExtendWith(MockitoExtension.class)
//class UserMapperTest {
//
//   private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
//
//    Users users = new Users();
//
//    UserDTO userDto = new UserDTO();
//
//    UserRole userRole1 = new UserRole();
//
//    UserRole userRole2 = new UserRole();
//
//    UserSkills userSkills1 = new UserSkills();
//
//    UserSkills userSkills2 = new UserSkills();
//
//    @Test
//    public void contextLoad(){
//    }
//
//    @BeforeEach
//    public void setup(){
//        //Given
//        users.setProviderToken("testProviderToken");
//        users.setEmail("test@example.com");
//        users.setFirstName("John");
//        users.setLastName("Doe");
//        users.setProviderId(1234L);
//        users.setPassword("password123");
//        users.setSignInCount(5);
//        users.setSessionToken("sessionToken");
//        users.setResetPasswordToken("resetPasswordToken");
//        users.setPhotoUrl("http://example.com/photo.jpg");
//        users.setPhoneNumber("1234567890");
//        users.setLastSignIn(new Date());
//        users.setLastSignIp("127.0.0.1");
//        users.setCurrentSignIp("127.0.0.1");
//        users.setCurrentSignIn(new Date());
//
//        userDto.setEmail("test@example.com");
//        userDto.setFirstName("John");
//        userDto.setLastName("Doe");
//        userDto.setProviderId(1234L);
//        userDto.setPassword("password123");
//        userDto.setSignInCount(5);
//        userDto.setSessionToken("sessionToken");
//        userDto.setResetPasswordToken("resetPasswordToken");
//        userDto.setPhotoUrl("http://example.com/photo.jpg");
//        userDto.setPhoneNumber("1234567890");
//        userDto.setLastSignIn(new Date());
//        userDto.setLastSignIp("127.0.0.1");
//        userDto.setCurrentSignIp("127.0.0.1");
//        userDto.setCurrentSignIn(new Date());
//
//        Roles roles1 = new Roles();
//        roles1.setName("Major");
//        roles1.setDescription("Commands a unit of 4");
//
//        Roles roles2 = new Roles();
//        roles2.setName("Soldier");
//        roles2.setDescription("Basic Unit");
//
//        userRole1.setRoles(roles1);
//        userRole2.setRoles(roles2);
//
//        Skills skills1 = new Skills();
//        skills1.setName("Fire");
//        skills1.setDescription("uses fire element");
//
//        Skills skills2 = new Skills();
//        skills2.setName("Water");
//        skills2.setDescription("uses water element");
//
//        userSkills1.setSkills(skills1);
//        userSkills2.setSkills(skills2);
//    }
//
//    @Test
//    public void testUserToUserDto(){
//        // When
//        UserDTO testUserDto = userMapper.usersToUserDTO(users);
//
//        // Then
//        assertEquals(users.getEmail(), testUserDto.getEmail());
//        assertEquals(users.getFirstName(), testUserDto.getFirstName());
//        assertEquals(users.getLastName(), testUserDto.getLastName());
//        assertEquals(users.getProviderId(), testUserDto.getProviderId());
//        assertEquals(users.getPassword(), testUserDto.getPassword());
//        assertEquals(users.getSignInCount(), testUserDto.getSignInCount());
//        assertEquals(users.getSessionToken(), testUserDto.getSessionToken());
//        assertEquals(users.getResetPasswordToken(), testUserDto.getResetPasswordToken());
//        assertEquals(users.getPhotoUrl(), testUserDto.getPhotoUrl());
//        assertEquals(users.getPhoneNumber(), testUserDto.getPhoneNumber());
//        assertEquals(users.getLastSignIn(), testUserDto.getLastSignIn());
//        assertEquals(users.getLastSignIp(), testUserDto.getLastSignIp());
//        assertEquals(users.getCurrentSignIp(), testUserDto.getCurrentSignIp());
//        assertEquals(users.getCurrentSignIn(), testUserDto.getCurrentSignIn());
//
//    }
//
//    @Test
//    public void testUserDTOToUsers(){
//        // When
//        Users testUser = userMapper.userDtoToUsers(userDto);
//
//        testUser.setUserRole(Set.of(userRole1 , userRole2));
//        testUser.setUserSkills(Set.of(userSkills1 , userSkills2));
//
//        // Then
//        assertEquals(userDto.getEmail(), testUser.getEmail());
//        assertEquals(userDto.getFirstName(), testUser.getFirstName());
//        assertEquals(userDto.getLastName(), testUser.getLastName());
//        assertEquals(userDto.getProviderId(), testUser.getProviderId());
//        assertEquals(userDto.getPassword(), testUser.getPassword());
//        assertEquals(userDto.getSignInCount(), testUser.getSignInCount());
//        assertEquals(userDto.getSessionToken(), testUser.getSessionToken());
//        assertEquals(userDto.getResetPasswordToken(), testUser.getResetPasswordToken());
//        assertEquals(userDto.getPhotoUrl(), testUser.getPhotoUrl());
//        assertEquals(userDto.getPhoneNumber(), testUser.getPhoneNumber());
//        assertEquals(userDto.getLastSignIn(), testUser.getLastSignIn());
//        assertEquals(userDto.getLastSignIp(), testUser.getLastSignIp());
//        assertEquals(userDto.getCurrentSignIp(), testUser.getCurrentSignIp());
//        assertEquals(userDto.getCurrentSignIn(), testUser.getCurrentSignIn());
//
//        Set<UserRole> testRole = testUser.getUserRole();
//        Set<UserSkills> testSkills = testUser.getUserSkills();
//
//        List<UserRole> testUserRoleList = new ArrayList<>(testRole);
//        List<UserSkills> testUserSkillsList = new ArrayList<>(testSkills);
//
//        assertNotNull(testRole);
//        assertNotNull(testSkills);
//        assertTrue(testRole.contains(userRole1));
//        assertTrue(testSkills.contains(userSkills2));
//
//        assertEquals(testUserSkillsList.get(1).getSkills().getName() , "Water");
//        assertEquals(testUserSkillsList.get(0).getSkills().getName() , "Fire");
//        assertEquals(testUserRoleList.get(0).getRoles().getName() , "Major");
//        assertEquals(testUser.getCreatedBy() , "GameDoora");
//
//    }
//}