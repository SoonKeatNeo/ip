package duke.task;

/**
 * Implementation for {@Task} with no schedules assigned.
 * @author Soon Keat Neo
 * @version CS2103T AY20/21 Sem 1 iP
 */

public class Todo extends Task {
    public Todo(String taskName) {
        super(taskName, "T");
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
