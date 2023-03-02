package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ClientApp {
    Socket sock;
    Scanner scanner = new Scanner(System.in);
    String request;
    String answer;

    {
        try {
            sock = new Socket("localhost", 5050);

            DataOutputStream dataOutputStream = new DataOutputStream(sock.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(sock.getInputStream());

            while(true){
                System.out.println("Для расчёта уравнения начните со знака =, например, =2+24*(10-8)\n" +
                                   "для завершения отправьте end");
                request = scanner.nextLine();
                dataOutputStream.writeUTF(request + "");
                if ("end".equals(request)) break;
                answer = dataInputStream.readUTF().toString();
                System.out.println("Ответ сервера: " + answer);
            }
        } catch (IOException e) {
            System.out.println("Ошибка к");
            e.printStackTrace();
        }
    }


}
