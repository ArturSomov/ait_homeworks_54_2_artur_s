package homework_40;

///Задание 2

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskManager {

    private static final String FILE_PATH = "src/main/resources/tasks.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Add new task: ");
        String newTask = scanner.nextLine();


        addTask(newTask);


        System.out.println("\nUpdated to do list:");
        readTasks();

        scanner.close();
    }

    // Метод для добавления новой задачи в файл
    private static void addTask(String task) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) { // append = true
            writer.write(System.lineSeparator() + task);
            System.out.println("Task added!");
        } catch (IOException e) {
            System.out.println("Error while adding to .txt file: " + e.getMessage());
        }
    }

    // Метод для чтения и вывода задач из файла
    private static void readTasks() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String task;
            while ((task = br.readLine()) != null) {
                System.out.println("- " + task);
            }
        } catch (IOException e) {
            System.out.println("Error while reading a file: " + e.getMessage());
        }
    }
}
