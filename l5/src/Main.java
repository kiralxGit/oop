import socket.ClientApp;
import socket.ServerApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Отправьте\n\t1 для запуска сервера\n\t2 для запуска клиента");
        Scanner sc = new Scanner(System.in);
        int n;
        try {
            n = Integer.parseInt(sc.next());
            switch (n){
                case 1:
                    ServerApp server = new ServerApp();
                    break;
                case 2:
                    ClientApp client = new ClientApp();
                    break;
                default:
                    System.out.printf("%nКоманда %d не найдена%n", n);
            }

        } catch (Exception ex) {
            System.out.println("Не распознано! Перепроверьте ввод!");
        }
        System.out.println("------ Работа программы завершена ------");
    }
}
