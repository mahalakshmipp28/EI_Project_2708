**Astronaut Daily Schedule Organizer**

This is a console-based application that helps astronauts organize their daily schedules. The application allows users to add, remove, and view daily tasks. Each task has a description, start time, end time, and priority level.
Design Patterns and OOP Concepts

This application uses the following design patterns and OOP concepts:

**1. Singleton Pattern:** The ScheduleManager class is a singleton, ensuring that there is only one instance of the schedule manager.

**2. Factory Pattern:** The TaskFactory class is a factory that creates Task objects.

**3. Observer Pattern:** The ScheduleManager class notifies users of task conflicts or updates.

**4. Encapsulation:** Each class encapsulates its own data and behavior, making it easier to modify and extend the code.

**5. Abstraction:** The Task class abstracts away the details of a task, making it easier to work with tasks without worrying about their implementation.

**6. Inheritance:** Not used in this application, but could be used to create subclasses of Task for specific types of tasks.

**7. Polymorphism:** Not used in this application, but could be used to create methods that can work with different types of tasks.

**Classes and Methods**

**ScheduleManager**

**1. Constructor:** Initializes the schedule manager with an empty list of tasks and a task factory.

**2. addTask:** Adds a new task to the schedule. Checks for conflicts with existing tasks and notifies the user if a conflict is found.

**3. removeTask:** Removes a task from the schedule. Notifies the user if the task is not found.

**4. viewTasks:** Displays all tasks in the schedule, sorted by start time.

**5. main:** The main method that runs the application. It creates a schedule manager and a scanner to read user input.

**Task**

**1. Constructor:** Initializes a task with a description, start time, end time, and priority.

**2. getDescription:** Returns the task's description.

**3. getStartTime:** Returns the task's start time.

**4. getEndTime:** Returns the task's end time.

**5. getPriority:** Returns the task's priority.

**5. conflictsWith:** Checks if the task conflicts with another task.

**TaskFactory**

**createTask:** Creates a new task with the given description, start time, end time, and priority.

**Usage**
To use the application, simply run the Main class. The application will prompt you to choose an action:
1. Add task
2. Remove task
3. View tasks
4. Exit

Follow the prompts to add, remove, or view tasks.
