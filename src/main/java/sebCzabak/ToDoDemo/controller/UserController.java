package sebCzabak.ToDoDemo.controller;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;



import sebCzabak.ToDoDemo.model.User;
import sebCzabak.ToDoDemo.service.TaskService;
import sebCzabak.ToDoDemo.service.UserService;



@RestController
@RequestMapping(path = "/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final TaskService taskService;

    @GetMapping(path = "/{userId}")
    public User getUserById(@PathVariable final Long userId){
        return userService.findById(userId);
    }
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }
    @PostMapping(path = "/{userId}/tasks")
    public void addNewToDo(@PathVariable Long userId){
        taskService.findById(userId);
    }
    @PostMapping(path="/tasks/{taskId}")
    public void toggleTaskDone(@PathVariable Long taskId){
        taskService.findById(taskId);
    }
    @DeleteMapping("tasks/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.findTaskById(taskId);
    }
}
