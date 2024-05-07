import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver
{

    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(5000);

        Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        while ((line = in.readLine()) != null)
        {
            System.out.println(line);
        }

        in.close();
        socket.close();
        serverSocket.close();
    }
}