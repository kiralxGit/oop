import java.time.LocalDate;

public class Task extends Tasks{
    public Task(String user, String description, LocalDate finishTime, boolean important, boolean done, LocalDate createdTime) {
        super(user, description, finishTime, important, done, createdTime);
    }
    public Task(String user, String description, LocalDate finishTime, boolean important) {
        super(user, description, finishTime, important);
    }

    public Task(String user, String description, LocalDate finishTime) {
        super(user, description, finishTime, false);
    }

}


