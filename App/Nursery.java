package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nursery {
    private final List <Animal> animals = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void showAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal.getInfo());
        }
    }

    public String showCommands() {
        System.out.println("Введите имя животного: ");
        String name = scan.nextLine();
        for (Animal animal : animals) {
            if (name.equals(animal.getName())) {
                return "Команды " + name + ": " + animal.getCommands();
            }
        }
        return "Животное не найдено";
    }
    public void addAnimal() {
        try {
            System.out.println("""
                        Выберите тип:        \s
                        1. Собака
                        2. Кошка
                        3. Хомяк
                        4. Лошадь
                        5. Верблюд
                        6. Осел
                        Введите опцию:\s""");
            String choice = scan.nextLine();

            System.out.println("Введите имя: ");
            String name = scan.nextLine();
            System.out.println("Введите возраст: ");
            int age = Integer.parseInt(scan.nextLine());
            Animal animal = null;

            if (choice.matches("1"))
                animal = new Dog(name, age);
            if (choice.matches("2"))
                animal = new Cat(name, age);
            if (choice.matches("3"))
                animal = new Hamster(name, age);
            if (choice.matches("4"))
                animal = new Horse(name, age);
            if (choice.matches("5"))
                animal = new Camel(name, age);
            if (choice.matches("6"))
                animal = new Donkey(name, age);

            animals.add(animal);

            try (Counter counter = new Counter()){
                counter.add();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void addCommand() {
        System.out.println("Введите имя животного: ");
        String name = scan.nextLine();
        for (Animal animal : animals) {
            if (name.equals(animal.getName())) {
                System.out.println("Введите команду: ");
                String command = scan.nextLine();
                animal.setCommands(command);
            }
            else
                System.out.println("Животное не найдено");
        }
    }
}







