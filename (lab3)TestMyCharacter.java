public class TestMyCharacter {
    public static void main(String[] args) {
        // Создание объекта MyCharacter
        MyCharacter myCharacter = new MyCharacter('a');

        // Вывод значения символа
        System.out.println("Значение символа: " + myCharacter.charValue());

        // Сравнение двух объектов MyCharacter
        MyCharacter myCharacter2 = new MyCharacter('b');
        System.out.println("Сравнение двух символов: " + myCharacter.compareTo(myCharacter2));

        // Сравнение объекта MyCharacter и символа
        char ch = 'c';
        System.out.println("Сравнение символа и объекта MyCharacter: " + myCharacter.compareTo(ch));

        // Проверка, является ли символ цифрой
        System.out.println("Проверка, является ли символ цифрой: " + myCharacter.isDigit());

        // Проверка, является ли символ цифрой (статический метод)
        System.out.println("Проверка, является ли символ цифрой (статический метод): " + MyCharacter.isDigit(myCharacter));

        // Проверка, является ли символ буквой (статический метод)
        System.out.println("Проверка, является ли символ буквой (статический метод): " + MyCharacter.isLetter(myCharacter));

        // Проверка, является ли символ буквой или цифрой (статический метод)
        System.out.println("Проверка, является ли символ буквой или цифрой (статический метод): " + MyCharacter.isLetterOrDigit(myCharacter));
    }
}
