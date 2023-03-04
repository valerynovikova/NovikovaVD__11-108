package controller;

import dto.CreateUserRequestDto;
import dto.UserResponseDto;
import lombok.AllArgsConstructor;
import model.User;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;
import service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;


    @GetMapping(value = {"/users/{id}", "users"})
    public List<UserResponseDto> user(@PathVariable(required = false) Optional<Integer> id) {
        if (id.isPresent()) {
            return userRepository.findAllById(List.of(id.get()))
                    .stream().map(u -> UserResponseDto.builder()
                            .name(u.getName())
                            .id(u.getId())
                            .email(u.getEmail())
                            .build()
                    ).collect(Collectors.toList());
        } else {
            return userService.findAll();
        }
    }

    @GetMapping("/hello")
    public String hello(@RequestParam Optional<String> name) {
        return String.format("Hello, %s!", name.orElse("Ivan"));
    }

    @PostMapping("/user")
    public UserResponseDto createUser(@Valid @RequestBody CreateUserRequestDto user) {
        return UserResponseDto.fromEntity(userRepository.save(
                User.builder()
                        .name(user.getName().trim())
                        .email(user.getEmail().trim())
                        .build()
        ));
    }
}
