package com.gamedoora.backend.userservices.assembler;

import com.gamedoora.model.dto.UserDTO;
import com.gamedoora.model.mapper.UserMapper;
import com.gamedoora.backend.userservices.repository.UsersRepository;
import com.gamedoora.model.dao.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServicesAssembler {

  private UsersRepository usersRepository;

  private UserMapper userMapper;

  public UsersRepository getUsersRepository() {
    return usersRepository;
  }

  @Autowired
  public void setUsersRepository(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  public UserMapper getUserMapper() {
    return userMapper;
  }

  @Autowired
  public void setUserMapper(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public UserDTO createUsers(UserDTO userDto) {

    Users users = userMapper.userDtoToUsers(userDto);
    usersRepository.save(users);
    return userDto;
  }

  public UserDTO updateUsers(long id, UserDTO userDto) {

    Optional<Users> usersRes = usersRepository.findById(id);
    if (usersRes.isPresent()) {
      return null;
    }
    Users users = usersRes.get();
    users.setEmail(userDto.getEmail());
    users.setFirstName(userDto.getFirstName());
    users.setLastName(userDto.getLastName());
    usersRepository.save(users);

    return userDto;
  }

  public void deleteUsers(long id) {
    getUsersRepository().deleteById(id);
  }

  public void deleteAllUsers() {
    getUsersRepository().deleteAll();
  }

  public List<UserDTO> getAllUsers(String email) {

    List<UserDTO> usersDto = new ArrayList<>();
    if (email == null) usersRepository.findAll().forEach(user -> usersDto.add(getUserMapper().usersToUserDTO(user)));
    else usersRepository.findByEmailContaining(email).forEach(user -> usersDto.add(getUserMapper().usersToUserDTO(user)));
    if (usersDto.isEmpty()) {
      return null;
    }
    return usersDto;
  }
}