import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        // Создание сокета
        Socket socket = new Socket("localhost", 5000);

        // Получение потоков ввода и вывода
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Чтение сообщений с консоли и отправка их на сервер
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String message;
        while ((message = console.readLine()) != null) {
            out.println(message);
        }

        // Закрытие потоков и сокета
        in.close();
        out.close();
        socket.close();
    }
}
Приложение 2 (сервер)

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Создание серверного сокета
        ServerSocket serverSocket = new ServerSocket(5000);

        // Бесконечный цикл для приема клиентов
        while (true) {
            // Принятие соединения
            Socket client = serverSocket.accept();

            // Добавление клиента в список
            clients.add(client);

            // Создание потока для обработки сообщений от клиента
            new Thread(new ClientHandler(client)).start();
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Получение потоков ввода и вывода
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                // Чтение сообщений от клиента и отправка их всем другим клиентам
                String message;
                while ((message = in.readLine()) != null) {
                    for (Socket otherClient : clients) {
                        if (otherClient != client) {
                            PrintWriter otherOut = new PrintWriter(otherClient.getOutputStream(), true);
                            otherOut.println(message);
                        }
                    }
                }

                // Удаление клиента из списка
                clients.remove(client);

                // Закрытие потоков и сокета
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
