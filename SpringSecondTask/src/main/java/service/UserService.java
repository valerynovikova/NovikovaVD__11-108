package service;

import dto.UserResponseDto;

public interface UserService {

    UserResponseDto addUser(UserResponseDto user);

    UserResponseDto updateUser(Integer userId, UserResponseDto newData);

    void deleteUser(Integer userId);
}