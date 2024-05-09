import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

interface StringComparator {
    String compare(String s1, String s2);
}

public class LongestStringInFile
{

    public static void main(String[] args) throws IOException {
        // Создаем функциональный интерфейс
        StringComparator comparator = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;

        // Открываем файл для чтения
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        // Инициализируем самую длинную строку пустой строкой
        String longestString = "";

        // Читаем строки из файла
        String line;
        while ((line = reader.readLine()) != null) {
            // Сравниваем текущую строку с самой длинной строкой
            longestString = comparator.compare(longestString, line);
        }

        // Закрываем файл
        reader.close();

        // Выводим самую длинную строку
        System.out.println("Самая длинная строка: " + longestString);
    }
}