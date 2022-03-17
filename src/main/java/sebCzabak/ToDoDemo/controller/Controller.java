package sebCzabak.ToDoDemo.controller;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;


import sebCzabak.ToDoDemo.model.Task;
import sebCzabak.ToDoDemo.model.User;
import sebCzabak.ToDoDemo.request.TaskRequest;
import sebCzabak.ToDoDemo.request.UserRequest;
import sebCzabak.ToDoDemo.service.TaskService;
import sebCzabak.ToDoDemo.service.UserService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/v1/")
@AllArgsConstructor
public class Controller {

    private final UserService userService;
    private final TaskService taskService;

    @GetMapping(name = "Get User By ID", path = "/{userId}")
    public Optional<User> getUserById(@PathVariable final Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping(path = "allUsers")
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }

    @GetMapping(path = "/allTasks")
    public List<Task>getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping(path = "/addUser")
    public User addUser(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

    @PostMapping(path = "addToDo/{userId}/tasks")
    public void addNewToDo(@PathVariable Long userId, @RequestBody TaskRequest taskRequest){
        userService.addNewToDo(userId,taskRequest);
    }

    @PostMapping(path="toggle/tasks/{taskId}")
    public void toggleTaskDone(@PathVariable Long taskId){
        taskService.toggleTaskDone(taskId);
    }

    @DeleteMapping("delete/{userId}/tasks/{taskId}")
    public void deleteTask(@PathVariable Long userId,@PathVariable Long taskId){
        userService.deleteTask(userId,taskId);
    }

    @DeleteMapping(path = "delete/user/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
