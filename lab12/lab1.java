import java.io.*;
import java.net.*;

public class Sender {

    public static void main(String[] args) throws IOException {
        // Создание сокета
        Socket socket = new Socket("localhost", 5000);

        // Получение потока вывода для отправки данных
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Чтение файла
        File file = new File("text.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));

        // Чтение и отправка английских букв
        String line;
        while ((line = in.readLine()) != null) {
            // Удаление русских букв
            line = line.replaceAll("[а-яА-Я]", "");

            // Отправка английских букв
            out.println(line);
        }

        // Закрытие потоков
        in.close();
        out.close();
        socket.close();
    }
}
Приложение 2 (получатель)

import java.io.*;
import java.net.*;

public class Receiver {

    public static void main(String[] args) throws IOException {
        // Создание сокета
        ServerSocket serverSocket = new ServerSocket(5000);

        // Принятие соединения
        Socket socket = serverSocket.accept();

        // Получение потока ввода для чтения данных
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Чтение и вывод полученного текста
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }

        // Закрытие потоков
        in.close();
        socket.close();
        serverSocket.close();
    }
}
