package sebCzabak.ToDoDemo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskRequest {
    private String description;
    private boolean done ;

}
