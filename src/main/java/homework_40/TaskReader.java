package homework_40;

///Задание 1

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TaskReader {

    public static void main(String[] args) {

        String filePath = "src/main/resources/tasks.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String task;
            System.out.println("To do list:");
            while ((task = br.readLine()) != null) {
                System.out.println("- " + task);
            }
        } catch (IOException e) {
            System.out.println("Error while reading a file: " + e.getMessage());
        }
    }
}
