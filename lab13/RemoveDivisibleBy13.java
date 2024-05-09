import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface IsDivisibleBy13
{
    boolean isDivisible(int number);
}


public class RemoveDivisibleBy13
{

    public static void main(String[] args) throws IOException
    {
        IsDivisibleBy13 divisibleBy13 = number -> number % 13 == 0;

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        String line;
        while ((line = reader.readLine()) != null)
        {
            int number = Integer.parseInt(line);
            if (!divisibleBy13.isDivisible(number))
            {
                writer.write(line + "\n");
            }
        }
        reader.close();
        writer.close();
    }
}