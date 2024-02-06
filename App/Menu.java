package App;

import java.util.Scanner;

public class Menu {
    private boolean exit = false;
    Nursery nurs = new Nursery();

    public void showMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (!exit) {
                System.out.println("""
                                               
                        1. Список животных
                        2. Список команд животного
                        3. Добавить животноe
                        4. Научить животное
                        5. Выход
                        Введите опцию:\s""");

                String choice = scanner.nextLine();
                if (choice.matches("1"))
                    nurs.showAnimals();
                if (choice.matches("2"))
                    System.out.println(nurs.showCommands());
                if (choice.matches("3"))
                    nurs.addAnimal();
                if (choice.matches("4"))
                    nurs.addCommand();
                if (choice.matches("5"))
                    exit = true;
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
