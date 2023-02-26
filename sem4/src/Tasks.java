import java.time.LocalDate;
import java.util.Formatter;

public abstract class Tasks {
    private String user;
    private String description;
    private LocalDate finishTime;
    private boolean important;
    private boolean done;
    private LocalDate createdTime;

    public Tasks(String user, String description, LocalDate finishTime, boolean important, boolean done, LocalDate createdTime) {
        this.user = user;
        this.description = description;
        this.finishTime = finishTime;
        this.important = important;
        this.done = done;
        this.createdTime = createdTime;
    }
    public Tasks(String user, String description, LocalDate finishTime, boolean important) {
        this(user, description, finishTime, false, important, LocalDate.now());
    }

    public Tasks(String user, String description, LocalDate finishTime) {
        this(user, description, finishTime, false);
    }

    public String getUser() {
        return user;
    }

    public LocalDate getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDate finishTime) {
        this.finishTime = finishTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }
    public String toFormatString() {
        String s = String.format(" %-16s | %-32s | %-12s | %-6s | %-6s | %-12s%n",
                this.user,
                this.description,
                this.finishTime,
                this.important,
                this.done,
                this.createdTime);
        return s.toString();
    }
    @Override
    public String toString() {
        return "" + user + ';' + description + ';' + finishTime + ';' + important + ';' + done + ';' + createdTime;
    }
}
