import java.util.Arrays;

public class TestMyString2 {
    public static void main(String[] args) {
        char[] chars = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
        char[] chars1 = {'O', 'k', 'a', 'y'};
        MyString2 myString2 = new MyString2(chars);
        System.out.println("Исходная строка: " + myString2);

        MyString2 substring1 = myString2.substring(6);
        System.out.println("Подстрока, начиная с индекса 6: " + substring1);

        MyString2 substring2 = myString2.substring(0, 6);
        System.out.println("Подстрока, начиная с индекса 0 и заканчивая индексом 6: " + substring2);

        MyString2 myString2_2 = new MyString2(chars1);
        System.out.println("Сравнение двух строк: " + myString2.equals(myString2_2));

        String str = "Privet Mir";
        System.out.println("Сравнение строки и объекта MyString2: " + myString2.equals(str));
        
        char[] chars2 = myString2.toChars();
        System.out.println("Преобразование объекта MyString2 в массив символов: " + Arrays.toString(chars2));

        MyString2 myString2_3 = MyString2.valueOf(true);
        System.out.println("Создание объекта MyString2 из логического значения: " + myString2_3);
    }
}
