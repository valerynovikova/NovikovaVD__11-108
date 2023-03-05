package service;

import dto.UserDto;

public interface UserService {

    UserDto addUser(UserDto user);

    UserDto updateUser(Integer userId, UserDto newData);

    void deleteUser(Integer userId);
}