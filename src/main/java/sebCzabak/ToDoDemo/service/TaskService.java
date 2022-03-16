package sebCzabak.ToDoDemo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sebCzabak.ToDoDemo.repository.TaskRepository;
@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
}
