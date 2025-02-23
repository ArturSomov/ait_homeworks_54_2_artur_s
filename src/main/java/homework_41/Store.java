package homework_41;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


class Product implements Serializable {


    private static final long serialVersionUID = 1L;
    @Getter
    private String name;
    private double price;
    @Setter
    @Getter
    private int quantity;
    private transient String promoCode; // Не сериализуется

    public Product(String name, double price, int quantity, String promoCode) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promoCode = promoCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", promoCode='" + promoCode + '\'' +
                '}';
    }
}

@Slf4j
public class Store {

    private static final String FILE_NAME = "products.dat";
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public void addProduct(String name, double price, int quantity, String promoCode) {
        if (name == null || name.trim().isEmpty()) {
            log.warn("Название не может быть пустым.");
            return;
        }
        if (price < 0 || quantity < 0) {
            log.warn("Цена и количество не могут быть отрицательными.");
            return;
        }
        products.add(new Product(name, price, quantity, promoCode));
        log.info("Товар успешно добавлен: {}", name);
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(products);
            log.info("Данные успешно сохранены в файл.");
        } catch (IOException e) {
            log.error("Ошибка при сохранении: {}", e.getMessage());
        }
    }

    public void loadFromFile(Scanner scanner) {
        if (!products.isEmpty()) {
            log.warn("Текущие данные будут потеряны при загрузке нового списка.");
            System.out.print("Продолжить? (да/нет): ");
            if (!scanner.nextLine().equalsIgnoreCase("да")) {
                log.info("Загрузка отменена пользователем.");
                return;
            }
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                products = (List<Product>) obj;
                log.info("Данные успешно загружены из файла.");
            } else {
                throw new ClassCastException("Некорректный формат данных в файле.");
            }
        } catch (ClassCastException e) {
            log.error("Ошибка загрузки: {}", e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            log.error("Ошибка при загрузке: {}", e.getMessage());
        }
    }

    public void changeQuantity(String name, int delta) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                int newQuantity = p.getQuantity() + delta;
                if (newQuantity < 0) {
                    log.warn("Количество товара '{}' не может стать отрицательным.", name);
                    return;
                }
                p.setQuantity(newQuantity);
                log.info("Количество товара '{}' изменено на {}. Новое количество: {}", name, delta, newQuantity);
                return;
            }
        }
        log.warn("Товар '{}' не найден.", name);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            log.info("Нет доступных товаров.");
            System.out.println("Нет доступных товаров.");
        } else {
            for (Product product : products) {
                log.info("{}", product);
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить товар");
            System.out.println("2. Показать товары");
            System.out.println("3. Сохранить в файл");
            System.out.println("4. Загрузить из файла");
            System.out.println("5. Изменить количество товара");
            System.out.println("6. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Название: ");
                    String name = scanner.nextLine();
                    double price;
                    int quantity;
                    try {
                        System.out.print("Цена: ");
                        price = scanner.nextDouble();
                        System.out.print("Количество: ");
                        quantity = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        log.error("Ошибка: введите корректные числовые значения.");
                        scanner.nextLine();
                        continue;
                    }
                    System.out.print("Промокод: ");
                    String promoCode = scanner.nextLine();
                    store.addProduct(name, price, quantity, promoCode);
                    break;
                case 2:
                    store.displayProducts();
                    break;
                case 3:
                    store.saveToFile();
                    break;
                case 4:
                    store.loadFromFile(scanner);
                    break;
                case 5:
                    System.out.print("Название товара: ");
                    String productName = scanner.nextLine();
                    System.out.print("Изменение количества (+/-): ");
                    try {
                        int delta = scanner.nextInt();
                        scanner.nextLine();
                        store.changeQuantity(productName, delta);
                    } catch (InputMismatchException e) {
                        log.error("Ошибка: введите корректное число.");
                        scanner.nextLine();
                    }
                    continue;
                case 6:
                    log.info("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    log.warn("Некорректный ввод. Попробуйте снова.");
            }
        }
    }
}

