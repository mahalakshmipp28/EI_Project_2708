/*1. Composite Pattern
Use Case: File System
In this system, we have a file system that consists of files and directories. 
We want to treat both files and directories as a single unit, 
allowing us to perform operations on them uniformly.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Component (File System Component)
interface FileSystemComponent {
    int getSize();
    String getName();
}

// Leaf (File)
class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }
}

// Composite (Directory)
public class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Directory(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory name:");
        String directoryName = scanner.nextLine();

        Directory directory = new Directory(directoryName);

        while (true) {
            System.out.println("1. Add file");
            System.out.println("2. Remove file");
            System.out.println("3. Get directory size");
            System.out.println("4. Get directory name");
            System.out.println("5. Exit");

            System.out.println("Choose an option:");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.println("Enter the file name:");
                    String fileName = scanner.nextLine();

                    System.out.println("Enter the file size:");
                    int fileSize = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    File file = new File(fileName, fileSize);
                    directory.addComponent(file);
                    break;
                case 2:
                    System.out.println("Enter the file name to remove:");
                    String removeFileName = scanner.nextLine();

                    // Find the file to remove
                    for (FileSystemComponent component : directory.components) {
                        if (component.getName().equals(removeFileName)) {
                            directory.removeComponent(component);
                            System.out.println("File removed successfully");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Directory size: " + directory.getSize());
                    break;
                case 4:
                    System.out.println("Directory name: " + directory.getName());
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
