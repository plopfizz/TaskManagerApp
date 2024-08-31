import java.time.LocalDate;
import java.util.Scanner;

public class TaskManager {
    private final TaskManagerApp taskManagerApp;
    private static final String FILENAME = "tasks.ser";
    private final Scanner sc;

    public TaskManager() {
        taskManagerApp = new TaskManagerApp();
        sc = new Scanner(System.in);
    }

    public void start() {

        loadTask();
        boolean running = true;
        while (running) {
            System.out.println("\n TaskManagement System");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Save and Exit");
            System.out.println("Choose any option");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addTask();
                case 2 -> taskManagerApp.listTasks();
                case 3 -> markAsCompleted();
                case 4 -> deleteTask();
                case 5 -> {
                    saveTasks();
                    running = false;
                }
                default -> System.out.println("Invalid Option. Please try again");
            }
        }


    }

    private void addTask() {
        System.out.println("Enter the task Title");
        String title = sc.nextLine();
        System.out.println("Enter the task Description");
        String description = sc.nextLine();
        System.out.println("Enter the task due Date (YYYY-MM-DD): ");
        LocalDate dueDate = LocalDate.parse(sc.nextLine());

        Task task = new Task(title, description, dueDate, false);
        taskManagerApp.addTask((task));
        System.out.println("Task Added Successfully");


    }

    private void markAsCompleted() {
        System.out.println("Enter the title of the task to mark as completed");
        String title = sc.nextLine();
        for (Task t : taskManagerApp.getTasks()) {
            if (t.getTitle().equals(title)) {
                t.setCompleted(true);
                System.out.println("Task Marked as Completed");
                return;
            }
        }
    }

    private void loadTask() {
        taskManagerApp.loadTasks(FILENAME);
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.start();
    }

    private void deleteTask() {
        System.out.println("Enter the title of the task to be deleted");
        String title = sc.nextLine();
        Task taskToRemove = null;
        for (Task t : taskManagerApp.getTasks()) {
            if (t.getTitle().equals(title)) {
                taskToRemove = t;
                break;
            }
        }

        if (taskToRemove != null) {
            taskManagerApp.removeTask(taskToRemove);
            System.out.println("Task Removed Successfully");
        } else {
            System.out.println("Task Not Found");
        }
    }

    private void saveTasks() {

        taskManagerApp.saveTasks(FILENAME);
        System.out.println("Tasks Saved Successfully");


    }
}
