package sebCzabak.ToDoDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "done")
    private boolean done;
    @Column(name = "dateCreated")
    private LocalDate dateCrated;
    @Transient
    private Integer calcDate;

    public Integer getCalcDate() {
        return Period.between(this.dateCrated,LocalDate.now()).getDays();
    }
}
