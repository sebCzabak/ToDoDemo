package sebCzabak.ToDoDemo.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import sebCzabak.ToDoDemo.model.Task;
import sebCzabak.ToDoDemo.model.User;
import sebCzabak.ToDoDemo.repository.TaskRepository;
import sebCzabak.ToDoDemo.repository.UserRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
@AllArgsConstructor
public class MyConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public void run(final String... args) throws Exception {
        User user0 = new User(
                "TestName0",
                "1234",
                "test@example.com",
                new ArrayList<>()
        );
        User user1 = new User(
                "TestName1",
                "1234",
                "test@example.com",
                new ArrayList<>()
        );
        Task task0 = new Task(
                "Model Testing0",
                false,
                LocalDate.of(2022, Month.MARCH, 15)


        );
        Task task1 = new Task(
                "Model Testing01",
                false,
                LocalDate.of(2022, Month.MARCH, 15)


        );

        user0.getTaskList().add(task0);
        user1.getTaskList().add(task1);
        userRepository.saveAll(List.of(user0, user1));
        taskRepository.saveAll(List.of(task0, task1));

    };
}
