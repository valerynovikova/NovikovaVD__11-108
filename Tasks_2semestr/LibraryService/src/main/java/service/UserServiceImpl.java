package service;

import dto.UserResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(u -> UserResponseDto.builder()
                .name(u.getName())
                .id(u.getId())
                .email(u.getEmail())
                .build()
        ).collect(Collectors.toList());
    }
}

