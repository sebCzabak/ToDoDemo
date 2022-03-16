package sebCzabak.ToDoDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    @OneToMany
    private List<Task> taskList =new ArrayList<>();

    public User(final String username, final String password, final String email, final List<Task> taskList) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.taskList = taskList;
    }
}
