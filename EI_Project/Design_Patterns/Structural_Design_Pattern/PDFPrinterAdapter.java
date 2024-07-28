/*1. Adapter Pattern
Use Case: Old Printer Adapter
In this system, we have an old printer that only supports printing text files, 
but we want to print PDF files as well. 
We can create an adapter that converts the PDF file to a text file, allowing us to print it using the old printer.*/

import java.util.Scanner;

// Target (Printer)
interface Printer {
    void print(String filePath);
}

class OldPrinter implements Printer {
    @Override
    public void print(String filePath) {
        if (filePath.endsWith(".txt")) {
            System.out.println("Printing text file: " + filePath);
        } else {
            throw new IllegalArgumentException("Only text files are supported");
        }
    }
}

// Adaptee (PDF Converter)
class PDFConverter {
    public String convertToText(String pdfFilePath) {
        return pdfFilePath.replace(".pdf", ".txt");
    }
}

// Adapter (PDF Printer Adapter)
public class PDFPrinterAdapter implements Printer {
    private OldPrinter oldPrinter;
    private PDFConverter pdfConverter;

    public PDFPrinterAdapter(OldPrinter oldPrinter, PDFConverter pdfConverter) {
        this.oldPrinter = oldPrinter;
        this.pdfConverter = pdfConverter;
    }

    @Override
    public void print(String filePath) {
        if (filePath.endsWith(".pdf")) {
            String textFilePath = pdfConverter.convertToText(filePath);
            oldPrinter.print(textFilePath);
        } else {
            oldPrinter.print(filePath);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        OldPrinter oldPrinter = new OldPrinter();
        PDFConverter pdfConverter = new PDFConverter();
        PDFPrinterAdapter pdfAdapter = new PDFPrinterAdapter(oldPrinter, pdfConverter);

        try {
            pdfAdapter.print(filePath);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Do you want to print another file? (yes/no)");
        String response = scanner.nextLine();

        while (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the file path:");
            filePath = scanner.nextLine();

            try {
                pdfAdapter.print(filePath);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Do you want to print another file? (yes/no)");
            response = scanner.nextLine();
        }
    }
}
