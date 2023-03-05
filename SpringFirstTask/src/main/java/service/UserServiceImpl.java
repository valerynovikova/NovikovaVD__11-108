package service;

import dto.UserDto;
import exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import model.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import static dto.UserDto.fromEntity;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository usersRepository;

    @Override
    public UserDto addUser(UserDto user) {
        return fromEntity(usersRepository.save(
                User.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .build()));
    }

    @Override
    public UserDto updateUser(Integer userId, UserDto newData) {
        User user = usersRepository.findById(userId).orElseThrow(UserNotFoundException::new);

        user.setName(newData.getName());
        user.setEmail(newData.getEmail());

        return fromEntity(usersRepository.save(user));
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = usersRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        usersRepository.delete(user);
    }
}

