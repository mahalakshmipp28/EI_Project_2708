**EXERCISE 1 - DESIGN PATTERNS**

**BEHAVIORAL DESIGN PATTERNS**

**1. Strategy Pattern**

**Use Case: Payment Gateway**

In this system, we have a payment gateway that supports multiple payment methods (e.g., credit card, PayPal, and bank transfer). We want to decouple the payment method from the payment processor to make it easier to add new payment methods in the future.

**Output:**

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Payment_Gateway_1.png?raw=true)

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Payment_Gateway_2.png?raw=true)

**2. Observer Pattern**

**Use Case: Weather Forecast System**

In this system, we have a weather station that continuously monitors the temperature, humidity, and wind speed. We want to notify multiple displays (e.g., mobile app, website, and digital signage) whenever the weather conditions change.

**Output:**

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Weather_Forecast_1.png?raw=true)

**CREATIONAL DESIGN PATTERNS**

**1. Builder Pattern**

**Use Case: Car Manufacturing**

In this system, we have a car manufacturer that produces different types of cars (e.g., sedan, SUV, and truck). We want to create a builder that constructs a car step-by-step, allowing us to customize the car's features.

**Output:**

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Car_Manufacturing_1.png?raw=true)

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Car_Manufacturing_2.png?raw=true)

**2. Factory Method Pattern**

**Use Case: Document Reader**

In this system, we have a document reader that supports multiple file formats (e.g., PDF, DOCX, and TXT). We want to create a factory method that returns a concrete document reader based on the file format.

**Output:**

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Document_Reader_1.png?raw=true)

**STRUCTURAL DESIGN PATTERNS**

**1. Composite Pattern**

**Use Case: File System**

In this system, we have a file system that consists of files and directories. We want to treat both files and directories as a single unit, allowing us to perform operations on them uniformly.

**Output:**

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/File_Systems_1.png?raw=true)

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/File_Systems_2.png?raw=true)

**2. Adapter Pattern**

**Use Case: Old Printer Adapter**

In this system, we have an old printer that only supports printing text files, but we want to print PDF files as well. We can create an adapter that converts the PDF file to a text file, allowing us to print it using the old printer.

**Output:**

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Old_Printer_Adapter_1.png?raw=true)

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Old_Printer_Adapter_2.png?raw=true)

**EXERCISE 2 - Astronaut Daily Schedule Organizer**

**Problem Statement :**

Design and implement a console-based application that helps astronauts organize their daily schedules. The application should allow users to add, remove, and view daily tasks. Each task will have a description, start time, end time, and priority level. The intent behind this problem statement is to evaluate your ability to implement a basic CRUD (Create, Read, Update, Delete) application, manage data efficiently, and apply best coding practices. 

**How does it work?**

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

**Output:**

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Schedule_Organiser_1.png?raw=true)

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Schedule_Organiser_2.png?raw=true)

![image_alt](https://github.com/mahalakshmipp28/EI_Project_CSBS_TCE/blob/main/Schedule_Organiser_3.png?raw=true)
