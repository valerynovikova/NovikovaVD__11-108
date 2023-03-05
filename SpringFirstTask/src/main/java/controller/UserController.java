package controller;

import dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService usersService;


    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usersService.addUser(user));
    }

    @PutMapping("/{user-id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("user-id") Integer userId,
                                                  @RequestBody UserDto newData) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(usersService.updateUser(userId, newData));
    }

    @DeleteMapping("/{user-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("user-id") Integer userId) {
        usersService.deleteUser(userId);
    }

}
