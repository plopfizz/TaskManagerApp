import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerApp implements Serializable {

    private List<Task> tasks;

    public TaskManagerApp() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void listTasks() {
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public void saveTasks(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream((filename));

            ObjectOutputStream obj = new ObjectOutputStream(fileOut);
            obj.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Failed Saving Tasks" + e.getMessage());
        }

    }

    public void loadTasks(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            tasks = (List<Task>) in.readObject();
        } catch (ClassNotFoundException | RuntimeException | IOException e) {
            System.out.println("Error in loading tasks" + e.getMessage());
        }

    }
}

