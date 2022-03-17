package sebCzabak.ToDoDemo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sebCzabak.ToDoDemo.model.Task;
import sebCzabak.ToDoDemo.repository.TaskRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void toggleTaskDone(final Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalStateException("Task with id " + taskId + " doesn't exists!"));
        task.setDone(!task.isDone());
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


}
