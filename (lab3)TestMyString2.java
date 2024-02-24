import java.util.Arrays;

public class TestMyString2 {
    public static void main(String[] args) {
        // Создание объекта MyString2 из массива символов
        char[] chars = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
        MyString2 myString2 = new MyString2(chars);

        // Вывод строки
        System.out.println("Исходная строка: " + myString2);

        // Получение подстроки, начиная с указанного индекса
        MyString2 substring1 = myString2.substring(6);
        System.out.println("Подстрока, начиная с индекса 6: " + substring1);

        // Получение подстроки, начиная с указанного индекса и заканчивая указанным индексом
        MyString2 substring2 = myString2.substring(2, 8);
        System.out.println("Подстрока, начиная с индекса 2 и заканчивая индексом 8: " + substring2);

        // Сравнение двух объектов MyString2
        MyString2 myString2_2 = new MyString2(chars);
        System.out.println("Сравнение двух строк: " + myString2.equals(myString2_2));

        // Сравнение объекта MyString2 и строки
        String str = "Hello World";
        System.out.println("Сравнение строки и объекта MyString2: " + myString2.equals(str));

        // Преобразование объекта MyString2 в массив символов
        char[] chars2 = myString2.toChars();
        System.out.println("Преобразование объекта MyString2 в массив символов: " + Arrays.toString(chars2));

        // Создание объекта MyString2 из логического значения
        MyString2 myString2_3 = MyString2.valueOf(true);
        System.out.println("Создание объекта MyString2 из логического значения: " + myString2_3);
    }
}
