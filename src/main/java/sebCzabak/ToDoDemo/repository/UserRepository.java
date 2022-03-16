package sebCzabak.ToDoDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sebCzabak.ToDoDemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
