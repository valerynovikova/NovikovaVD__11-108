package ru.itis.novikova.service;

import org.postgresql.jdbc2.optional.SimpleDataSource;
import ru.itis.novikova.dto.UserDTO;
import ru.itis.novikova.repositorie.UserRepository;
import ru.itis.novikova.repositorie.UserRepositoryJdbcImpl;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("C:\Users\Валерия\IdeaProjects\SemestrWork2\src\main\resources\\application.properties"));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        this.userRepository = new UserRepositoryJdbcImpl(new SimpleDataSource(properties));
    }

    @Override

    @Override
    public UserDTO findUserByLogin(String login){
        return userRepository.findUserByLogin(login).get();
    }

    @Override
    public UserDTO findUserByNick(String  id) {
        return userRepository.findByNick(id);
    }

    @Override
    public UserDTO findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll();
    }
}
