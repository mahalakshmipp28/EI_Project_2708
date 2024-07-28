public class Task {
    private final String description;
    private final String startTime;
    private final String endTime;
    private final String priority;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

    public boolean conflictsWith(Task otherTask) {
        int startHour = Integer.parseInt(startTime.split(":")[0]);
        int startMinute = Integer.parseInt(startTime.split(":")[1]);
        int endHour = Integer.parseInt(endTime.split(":")[0]);
        int endMinute = Integer.parseInt(endTime.split(":")[1]);

        int otherStartHour = Integer.parseInt(otherTask.startTime.split(":")[0]);
        int otherStartMinute = Integer.parseInt(otherTask.startTime.split(":")[1]);
        int otherEndHour = Integer.parseInt(otherTask.endTime.split(":")[0]);
        int otherEndMinute = Integer.parseInt(otherTask.endTime.split(":")[1]);

        if (startHour < otherEndHour && endHour > otherStartHour) {
            return true;
        }
        return false;
    }
}