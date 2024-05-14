import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // Серверный сокет на порту 5000
        ServerSocket serverSocket = new ServerSocket(5000);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {

            Socket clientSocket = serverSocket.accept();

            // Поток ввода от клиента
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Чтение сообщение от клиента
            String message = in.readLine();

            // Выводим  в консоль
            System.out.println(message);

            // Отправка ответа
            String message1 = keyboard.readLine();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(message1);
        }
    }
}