public static boolean isReference(String text) {
    Pattern pattern = Pattern.compile("^(\\d+)\\. (.*), (.*)\\. (.*)\\. (\\d{4});(\\d\\(\\d\\)):(\\d+)-(\\d+)$");
    Matcher matcher = pattern.matcher(text);
    return matcher.matches();
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReferenceFinder {

    public static void main(String[] args) {
        try {
            // Считать текст из файла
            File file = new File("text.txt");
            Scanner scanner = new Scanner(file);
            String text = scanner.useDelimiter("\\A").next();
            scanner.close();

            // Найти все ссылки на литературу
            Pattern pattern = Pattern.compile("^(\\d+)\\. (.*), (.*)\\. (.*)\\. (\\d{4});(\\d\\(\\d\\)):(\\d+)-(\\d+)$");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                // Вывести ссылку на консоль
                System.out.println(matcher.group());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
