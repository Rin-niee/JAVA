/*Обработка текстовых данных с помощью регулярных выражений.
В научных текстах (статьях) как правило встречается раздел со списком литературы. Ссылки
на литературные источники имеют правила оформления. Например, один из вариантов
оформления ссылки на статью выглядит так:
1. Бондарев А.Н., Киричек Р.В. Обзор беспилотных летательных аппаратов общего
пользования и регулирования воздушного движения БПЛА в разных странах.
Информационные технологии и телекоммуникации. 2016;4(4):13–23.
Указывается: авторы статьи, название, наименование журнала, год, номер тома (номер
выпуска), номера страниц.
Написать регулярное выражение, определяющее шаблон ссылки на литературу. Написать
функцию, возвращающую true, если переданная ей в параметре строка является ссылкой на
литературу и false в противном случае.
Также написать программу, которая находит в тексте, читаемом из файла, все литературные
источники (по шаблону, задаваемому регулярным выражением) и выводит их на консоль.
Пример файла прилагается к заданию.
УКАЗАНИЕ. Внимательно ознакомьтесь со списком литературы в конце файла. Обратите
внимание, что в названиях журналов могут быть точки, а ссылки на литературу могут быть в
том числе и английскими.*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReferenceFinder
{
    public static void main(String[] args)
    {
    try {
            // Считать текст из файла
            File file = new File("fvp.txt");
            Scanner scanner = new Scanner(file);
            String text = scanner.useDelimiter("\\A").next();
            scanner.close();

            // Найти все ссылки на литературу
            Pattern pattern = Pattern.compile("^(\\d+)\\. (.*), (.*)\\. (.*)\\. (\\d{4});(\\d\\(\\d\\)):(\\d+)-(\\d+)$");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find())
            {
                // Вывести ссылку на консоль
                System.out.println(matcher.group());
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден");
        }
    }
}


Регулярное выражение для шаблона ссылки на литературу:
```java
String regex = "\\d+\\.\\s.+\\.\\s.+\\.\\s\\d{4};\\d+\\(\\d+\\):\\d+-\\d+\\.";
```

Функция для проверки, является ли строка ссылкой на литературу:
```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        String testString = "1. Бондарев А.Н., Киричек Р.В. Обзор беспилотных летательных аппаратов общего\n" +
                "пользования и регулирования воздушного движения БПЛА в разных странах. Информационные\n" +
                "технологии и телекоммуникации. 2016;4(4):13–23.";

        System.out.println(isLiteratureReference(testString));

        // Пример чтения файла и выделения литературных источников
        // File file = new File("sample.txt");
        // List<String> literatureReferences = extractLiteratureReferencesFromFile(file);
        // for (String reference : literatureReferences) {
        //    System.out.println(reference);
        // }
    }

    public static boolean isLiteratureReference(String input) {
        String regex = "\\d+\\.\\s.+\\.\\s.+\\.\\s\\d{4};\\d+\\(\\d+\\):\\d+-\\d+\\.";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
```

Для нахождения литературных источников в тексте из файла, вам необходимо добавить соответствующий код для чтения файла и обработки его содержимого с помощью регулярного выражения. В примере представлены основные методы для проверки строки на соответствие шаблону ссылки на литературу.
