package sebCzabak.ToDoDemo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import sebCzabak.ToDoDemo.model.Task;
import sebCzabak.ToDoDemo.model.User;

import sebCzabak.ToDoDemo.repository.TaskRepository;
import sebCzabak.ToDoDemo.repository.UserRepository;
import sebCzabak.ToDoDemo.request.TaskRequest;
import sebCzabak.ToDoDemo.request.UserRequest;


import java.util.List;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;


    public User save(final UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addNewToDo(final Long userId, TaskRequest taskRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id " + userId + " doesn't exists"));
        Task task = new Task();
        task.setDescription(taskRequest.getDescription());
        task.setDone(!taskRequest.isDone());
        user.getTaskList().add(task);
        taskRepository.save(task);
        userRepository.save(user);
    }


    public Optional<User> getUserById(final Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id " + userId + " doesn't exists"));
        return userRepository.findById(userId);
    }

    public void deleteUser(final Long userId) {
        final boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " doesn't exists");
        }
        userRepository.deleteById(userId);
    }

    public void deleteTask(final Long userId,final Long taskId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id " + userId + " doesn't exists"));;
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalStateException("Task with id " + taskId + " doesn't exists!"));
        user.getTaskList().remove(task);
        taskRepository.delete(task);


    }
}




