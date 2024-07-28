import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScheduleManager {
    private final List<Task> tasks;
    private final TaskFactory taskFactory;

    public ScheduleManager() {
        tasks = new ArrayList<>();
        taskFactory = new TaskFactory();
    }

    public void addTask(Task task) {
        for (Task existingTask : tasks) {
            if (task.conflictsWith(existingTask)) {
                System.out.println("Error: Task conflicts with existing task \"" + existingTask.getDescription() + "\".");
                return;
            }
        }
        tasks.add(task);
        System.out.println("Task added successfully. No conflicts.");
    }

    public void removeTask(Task task) {
        for (Task existingTask : tasks) {
            if (existingTask.getDescription().equals(task.getDescription())) {
                tasks.remove(existingTask);
                System.out.println("Task removed successfully.");
                return;
            }
        }
        System.out.println("Error: Task not found.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task.getStartTime() + " - " + task.getEndTime() + ": " + task.getDescription() + " [" + task.getPriority() + "]");
        }
    }

    public static void main(String[] args) {
        ScheduleManager scheduleManager = new ScheduleManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. View tasks");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter start time (HH:mm): ");
                    String startTime = scanner.nextLine();
                    System.out.print("Enter end time (HH:mm): ");
                    String endTime = scanner.nextLine();
                    System.out.print("Enter priority (High/Medium/Low): ");
                    String priority = scanner.nextLine();

                    if (!isValidTime(startTime) || !isValidTime(endTime)) {
                        System.out.println("Error: Invalid time format.");
                        break;
                    }

                    Task task = scheduleManager.taskFactory.createTask(description, startTime, endTime, priority);
                    scheduleManager.addTask(task);
                    break;
                case 2:
                    System.out.print("Enter task description: ");
                    description = scanner.nextLine();

                    Task removeTask = scheduleManager.taskFactory.createTask(description, "", "", "");
                    scheduleManager.removeTask(removeTask);
                    break;
                case 3:
                    scheduleManager.viewTasks();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean isValidTime(String time) {
        String[] parts = time.split(":");
        if (parts.length != 2) {
            return false;
        }
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
    }
}