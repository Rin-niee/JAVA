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


public class Main{
    public static boolean isReference(String text)
    {
        Pattern pattern = Pattern.compile("\\\\d+\\\\.\\\\s.+\\\\.\\\\s.+\\\\.\\\\s\\\\d{4};\\\\d+\\\\(\\\\d+\\\\):\\\\d+-\\\\d+\\\\.");
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        String testString = "1. Бондарев А.Н., Киричек Р.В. Обзор беспилотных летательных аппаратов общего пользования и регулирования воздушного движения БПЛА в разных странах. Информационные технологии и телекоммуникации. 2016;4(4):13–23.";

        System.out.println(isReference(testString));

        try {
            // Считать текст из файла
            File file = new File("File.txt");
            Scanner scanner = new Scanner(file);
            StringBuilder text = new StringBuilder();
            while (scanner.hasNextLine())
            {
                text.append(scanner.nextLine()).append("\n");
            }
            scanner.close();

            // Найти все ссылки на литературу
            Pattern pattern = Pattern.compile("\\d+\\.\\s.+\\.\\s.+\\.\\s\\d{4};\\d+\\(\\d+\\):\\d+-\\d+\\.");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                // Вывести ссылку на консоль
                System.out.println(matcher.group());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Not found file.");
        }
    }
}
