import java.util.Objects;
import java.util.Scanner;


public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        SweetBox sweetBox = new SweetBox();

        sweetBox.addSweet(new Chocolate("Alpen Gold", 200, 9, "70%"));
        sweetBox.addSweet(new Candy("Клубничные конфеты", 100, 3.0, "Клубника"));
        sweetBox.addSweet(new Candy("Лимонная карамель", 150, 4.2, "Лимон"));
        sweetBox.addSweet(new Marshmallows("Зефир", 50, 3.5, "Розовый"));
        sweetBox.addSweet(new Halva("Халва Арахисовая", 550, 8.5, "Арахис"));
        sweetBox.addSweet(new Waffle("Вафли с апельсиновой начинкой", 450, 7, "Апельсиновый джем"));
        sweetBox.addSweet(new Waffle("Вафли c малиновой начинкой", 250, 3.9, "Малиновое варенье"));

        while (true) {
            if (sweetBox.isEmpty()) {
                System.out.println("Коробка сладостей пустая!");
                break;
            }
            System.out.println("\nДля выбора пункта меню, введите его номер." +
                    "\n1. Вывести содержимое коробки." +
                    "\n2. Вывести общий вес." +
                    "\n3. Вывести общую стоимость." +
                    "\n4. Удалить сладость по индексу. " +
                    "\n5. Оптимизировать вес коробки, удаляя сладости с меньшим весом." +
                    "\n6. Оптимизировать вес коробки, удаляя сладости с меньшей ценой." +
                    "\nДля выхода нажмите 0.\n");

            Scanner scanner = new Scanner(System.in);
            String newstring = scanner.nextLine();

            if (Objects.equals(newstring, "0")) {
                break;
            }

            switch (newstring) {
                case "1":
                    System.out.println(ANSI_GREEN + "Сладости в коробке:");
                    sweetBox.displaySweets();
                    System.out.print(ANSI_RESET);
                    break;
                case "2":
                    System.out.println(ANSI_GREEN + "Общий вес: " + sweetBox.getTotalWeight() + ANSI_RESET);
                    break;
                case "3":
                    System.out.println(ANSI_GREEN + "Общая цена: " + sweetBox.getTotalPrice() + ANSI_RESET);
                    break;
                case "4":
                    System.out.println(ANSI_BLUE + "Введите индекс от 0 до " + (sweetBox.getSweetCount() - 1) + ANSI_RESET);
                    String index = scanner.nextLine();
                    if (index.matches("-?\\d+") && Integer.parseInt(index) >= 0 &&
                            Integer.parseInt(index) < sweetBox.getSweetCount()) {
                        System.out.print(ANSI_GREEN);
                        sweetBox.removeSweet(Integer.parseInt(index));
                        System.out.print(ANSI_RESET);
                        break;
                    }
                    errorMessage();
                    break;
                case "5":
                    handleInput(scanner, sweetBox, "weight");
                    break;
                case "6":
                    handleInput(scanner, sweetBox, "price");
                    break;
                default:
                    errorMessage();
                    break;
            }
        }
    }

    static void errorMessage() {
        System.out.println(ANSI_BLUE + "Введено неверное значение. Начните сначала" + ANSI_RESET);
    }

    static void handleInput(Scanner scanner, SweetBox sweetBox, String action) {
        System.out.println(ANSI_BLUE + "Введите максимальный вес " + ANSI_RESET);
        String weight = scanner.nextLine();

        try {
            double maxWeight = Double.parseDouble(weight);

            if (maxWeight < 0) {
                errorMessage();
            } else {
                System.out.print(ANSI_GREEN);

                if ("weight".equals(action)) {
                    sweetBox.decreaseByWeight(maxWeight);
                } else if ("price".equals(action)) {
                    sweetBox.decreaseByPrice(maxWeight);
                }

                System.out.print(ANSI_RESET);
            }
        } catch (NumberFormatException e) {
            errorMessage();
        }
    }
}

