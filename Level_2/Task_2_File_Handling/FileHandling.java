import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {

    static Scanner sc = new Scanner(System.in);
    static String fileName = "notes.txt";

    // Create a file
    public static void createFile() {
        try {
            File file = new File(fileName);

            if (file.createNewFile()) {
                System.out.println("File created successfully!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.out.println("Error creating file.");
        }
    }

    // Write content into file
    public static void writeFile() {
        try {
            FileWriter writer = new FileWriter(fileName);

            System.out.print("Enter content: ");
            String content = sc.nextLine();

            writer.write(content);
            writer.close();

            System.out.println("Content written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Read content from file
    public static void readFile() {
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(fileName));

            String line;

            System.out.println("\nFile Content:");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file or file not found.");
        }
    }

    // Append content into file
    public static void appendFile() {
        try {
            FileWriter writer = new FileWriter(fileName, true);

            System.out.print("Enter content to append: ");
            String content = sc.nextLine();

            writer.write("\n" + content);
            writer.close();

            System.out.println("Content appended successfully!");

        } catch (IOException e) {
            System.out.println("Error appending to file.");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== FILE HANDLING APPLICATION =====");
            System.out.println("1. Create File");
            System.out.println("2. Write File");
            System.out.println("3. Read File");
            System.out.println("4. Append File");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    createFile();
                    break;

                case 2:
                    writeFile();
                    break;

                case 3:
                    readFile();
                    break;

                case 4:
                    appendFile();
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}