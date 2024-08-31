import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {

    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;

    public Task(String title, String description, LocalDate dueDate, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" + "title='" + title + '\'' + ", description='" + description + '\'' + ", dueDate=" + dueDate + ", isCompleted=" + isCompleted + '}';
    }

    public static void main(String[] args) {
        Task t = new Task("wake up", "i will wake up at 8 am", LocalDate.of(2024, 1, 8), false);
        System.out.println(t.toString());
    }
}
