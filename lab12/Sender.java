import java.io.*;
import java.net.Socket;

public class Sender
{

    public static void main(String[] args) throws IOException
    {
        Socket input = new Socket("localhost", 5000);

        PrintWriter out = new PrintWriter(input.getOutputStream(), true);

        File file = new File("text.txt");
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null)
        {
            line = line.replaceAll("[а-яА-Я]", "");
            out.println(line);
        }
        in.close();
        out.close();
        input.close();
    }
}