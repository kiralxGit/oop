package socket;

import calc.Calculator;
import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    ServerSocket serverSocket;
    String answer;

    {
        try {
            serverSocket = new ServerSocket(5050);
            System.out.println("Сервер запущен");
            Socket sock = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataOutputStream dataOutputStream = new DataOutputStream(sock.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(sock.getInputStream());

            while (true){
                String clientRequest = dataInputStream.readUTF();
                if ("end".equals(clientRequest)) break;
                System.out.println("Клиент прислал: " + clientRequest);
                if (clientRequest.startsWith("=")){
                    answer = String.valueOf(Calculator.getAnswer(clientRequest));
                    System.out.println("Ответ клиенту: " + answer);
                    dataOutputStream.writeUTF(answer);
                } else {
                    answer = (String)clientRequest;
                    dataOutputStream.writeUTF(answer);
                }



            }

        } catch (IOException e) {
            System.out.println("Ошибка с");
            e.printStackTrace();
        }
    }

}
