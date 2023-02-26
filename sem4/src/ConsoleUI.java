import java.time.LocalDate;
import java.util.*;

public class ConsoleUI {
    public void start(){
        printDescription();

        Program pr = new Program();

        boolean exit = false;
        int num;

        while (exit == false) {
            System.out.println("Выберите действие:\n" +
                    "1. Просмотреть список дел\n" +
                    "2. Добавить задачу\n" +
                    "3. Завершить задачу\n" +
                    "4. Удалить задачу\n" +
                    "0. Выход");
            num = getNum();
            switch (num) {
                case 1:
                    System.out.println(pr.printSchedule());
                    continue;
                case 2:
                    System.out.println(addNewTask(pr));
                    continue;
                case 3:
                    System.out.println(pr.printSchedule());
                    System.out.println("Введите номер завершаемой задачи");
                    System.out.println(completeTask(pr));
                    continue;
                case 4:
                    System.out.println(pr.printSchedule());
                    System.out.println("Введите номер удаляемой задачи");
                    System.out.println(deleteTask(pr));
                    continue;
                case 0:
                    exit = true;
                    continue;
                default:
                    System.out.println("Неверный параметр: " + num);
            }
        }
        System.out.println("Программа завершена.");

    }
    private boolean getBool() {
        int n;
        System.out.println(">>> ");
        Scanner inScanner = new Scanner(System.in);
        while (true) {
            String input = inScanner.next();
            try {
                n = Integer.parseInt(input);
                if(n == 0 || n == 1) break;
            } catch (Exception ex) {
                System.out.println("Не распознано! Введите число!");
            }
        }

        if (n > 0) return true;
        return false;
    }
    private int getNum() {
        int n;
        System.out.println(">>> ");
        Scanner inScanner = new Scanner(System.in);
        while (true) {
            String input = inScanner.next();
            try {
                n = Integer.parseInt(input);
                break;
            } catch (Exception ex) {
                System.out.println("Не распознано! Введите число!");
            }
        }

        if (n < 0) n *= -1;
        return n;
    }
    private String getStr() {
        String str = "";
        System.out.println(">>> ");
        Scanner inScanner = new Scanner(System.in);
        while (true) {
            str = inScanner.nextLine();
            try {
                if(str.length() > 0) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Не распознано! Введите строку!");
            }
        }
        return str;
    }

    private void printDescription() {
        System.out.println("\n\tСписок дел с сохранением в .txt файл, v. 1-а\n");
    }
    private String addNewTask(Program pr){
        Map<String, String> strings = new HashMap<>();

        System.out.println("Введите имя пользователя: ");
        strings.putIfAbsent("user", getStr());

        System.out.println("Введите описание задачи: ");
        strings.putIfAbsent("description", getStr());

        System.out.println("Введите дату заврешения (формат ГГГГ-ММ-ДД): ");
        strings.putIfAbsent("finishTime", getStr());

        System.out.println("Задача важная? 1 - да 0 - нет");
        strings.putIfAbsent("important", Boolean.toString(getBool()));

        if(pr.addNewTask(strings)){
            return("Задача добавлена!");
        } else {
            return("Ошибка добавления задачи!");
        }
    }
    private String deleteTask(Program pr){
        if(pr.deleteTask(getNum() - 1)){
            return("Задача удалена!");
        } else {
            return("Ошибка удаления задачи!");
        }
    }
    private String completeTask(Program pr){
        if(pr.completeTask(getNum() - 1)){
            return("Задача завершена!");
        } else {
            return("Ошибка завершения задачи!");
        }
    }
}
