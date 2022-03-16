package sebCzabak.ToDoDemo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sebCzabak.ToDoDemo.model.Task;
import sebCzabak.ToDoDemo.repository.TaskRepository;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task findById(final Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchElementException());
        task.setDone(!task.isDone());
        return taskRepository.save(task);
    }

    public void findTaskById(final Long taskId) {
        Task task =taskRepository.findById(taskId).orElseThrow(()->new NoSuchElementException());
        taskRepository.delete(task);
    }
}
