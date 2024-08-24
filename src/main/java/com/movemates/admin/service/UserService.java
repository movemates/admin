package com.movemates.admin.service;

import com.movemates.admin.model.User;
import com.movemates.admin.model.exception.UserAlreadyExistException;
import com.movemates.admin.model.exception.UserNotFoundException;
import com.movemates.admin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public String authenticate(User user) {
        User admin = userRepository.findById(user.getUserName())
                .orElseThrow(() -> new UserNotFoundException("Username not found!"));

        return Objects.equals(user.getPassword(), admin.getPassword())?"valid":"invalid password!";
    }

    public User register(User user) {
        boolean present = userRepository.findById(user.getUserName())
                .isPresent();
        if(present) {
            throw new UserAlreadyExistException("User already exist!");
        }
        return userRepository.save(user);
    }
}
