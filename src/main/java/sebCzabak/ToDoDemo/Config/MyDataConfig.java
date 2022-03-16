package sebCzabak.ToDoDemo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import sebCzabak.ToDoDemo.model.Task;
import sebCzabak.ToDoDemo.model.User;
import sebCzabak.ToDoDemo.repository.TaskRepository;
import sebCzabak.ToDoDemo.repository.UserRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@Configuration
public class MyDataConfig implements CommandLineRunner {

    private UserRepository userRepository;

    private TaskRepository taskRepository;

    public MyDataConfig(final UserRepository userRepository, final TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        User user0 = new User(
                "TestName0",
                "1234",
                "test@example.com",
                new ArrayList<>()
        );
        Task task0 = new Task(
                "Model Testing0",
                false,
                LocalDate.of(2022, Month.MARCH, 15),
                2

        );
        user0.getTaskList().add(task0);
        taskRepository.save(task0);
        userRepository.save(user0);


    }
}
