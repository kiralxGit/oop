package org.example;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    Controller controller = new Controller();
    public void runInterface(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Введите 1 для получения погоды на сегодня\n" +
                    "Введите 5 для прогноза на 5 дней\n" +
                    "Для выхода введите 0: ");

            String command = scanner.nextLine();

            System.out.println("Введите город: ");
            String city = scanner.nextLine();

            if(command.equals("0")) break;

            try{
                controller.getWeather(command, city);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
