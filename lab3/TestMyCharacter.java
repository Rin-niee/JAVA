public class TestMyCharacter {
    public static void main(String[] args) {
        MyCharacter myCharacter = new MyCharacter('m');
        System.out.println("Значение: " + myCharacter.charValue());
        
        MyCharacter myCharacter2 = new MyCharacter('n');
        System.out.println("Сравнение символов одного класса: " + myCharacter.compareTo(myCharacter2));
        
        char ch = 'k';
        System.out.println("Сравнение объектов: " + myCharacter.equals(ch));
        
        System.out.println("Проверка на число: " + myCharacter.isDigit());
        System.out.println("Проверка на число(статически): " + MyCharacter.isDigit(myCharacter));
        System.out.println("Проверка на символ(статически): " + MyCharacter.isLetter(myCharacter));
        System.out.println("Проверка на символ или число (статически): " + MyCharacter.isLetterOrDigit(myCharacter));
    }
}
