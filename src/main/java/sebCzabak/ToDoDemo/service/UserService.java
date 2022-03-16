package sebCzabak.ToDoDemo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import sebCzabak.ToDoDemo.model.User;

import sebCzabak.ToDoDemo.repository.UserRepository;

import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findById(final Long userId) {
        return userRepository.findById(userId).orElseThrow(()->new NoSuchElementException());
        }
    }




