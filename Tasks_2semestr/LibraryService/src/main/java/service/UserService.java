package service;

import dto.UserResponseDto;

import java.util.List;

public interface UserService {

    List<UserResponseDto> findAll();
}
