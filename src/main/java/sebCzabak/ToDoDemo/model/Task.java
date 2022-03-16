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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Task(final String description, final boolean done, final LocalDate dateCrated, final Integer calcDate) {
        this.description = description;
        this.done = done;
        this.dateCrated = dateCrated;
        this.calcDate = calcDate;
    }
}
