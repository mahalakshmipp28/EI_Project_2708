/*1. Factory Method Pattern
Use Case: Document Reader
In this system, we have a document reader that supports multiple file formats 
(e.g., PDF, DOCX, and TXT). 
We want to create a factory method that returns a concrete document reader based on the file format.*/

import java.util.Scanner;

// Product (Document Reader)
interface DocumentReader {
    void read(String filePath);
}

class PDFReader implements DocumentReader {
    @Override
    public void read(String filePath) {
        System.out.println("Reading PDF file: " + filePath);
    }
}

class DOCXReader implements DocumentReader {
    @Override
    public void read(String filePath) {
        System.out.println("Reading DOCX file: " + filePath);
    }
}

class TXTReader implements DocumentReader {
    @Override
    public void read(String filePath) {
        System.out.println("Reading TXT file: " + filePath);
    }
}

// Factory (Document Reader Factory)
public class DocumentReaderFactory {
    public static DocumentReader createDocumentReader(String fileFormat) {
        if (fileFormat.equalsIgnoreCase("PDF")) {
            return new PDFReader();
        } else if (fileFormat.equalsIgnoreCase("DOCX")) {
            return new DOCXReader();
        } else if (fileFormat.equalsIgnoreCase("TXT")) {
            return new TXTReader();
        } else {
            throw new IllegalArgumentException("Unsupported file format");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a file format:");
            System.out.println("1. PDF");
            System.out.println("2. DOCX");
            System.out.println("3. TXT");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (choice == 4) {
                break;
            }

            String fileFormat = null;

            switch (choice) {
                case 1:
                    fileFormat = "PDF";
                    break;
                case 2:
                    fileFormat = "DOCX";
                    break;
                case 3:
                    fileFormat = "TXT";
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();

            DocumentReader reader = createDocumentReader(fileFormat);
            reader.read(filePath);
        }

        scanner.close();
    }
}
