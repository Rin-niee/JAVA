import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException
    {
        // Создаем сокет для подключения к серверу
        Socket clientSocket = new Socket("localhost", 5000);

        // Поток вывода для отправки сообщения серверу
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Поток ввода для чтения сообщений от сервера
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // ввод с клавиатуры
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            // Ввод сообщения с клавиатуры
            String message = keyboard.readLine();

            // Отправка сообщение серверу
            out.println(message);

            // Чтение ответа от сервера
            String response = in.readLine();

            // Вывод в консоль
            System.out.println(response);
        }
    }
}