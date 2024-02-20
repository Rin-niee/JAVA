/*Java-библиотека предоставляет класс Character. Предоставьте собственную
реализацию следующих методов (назовите новый класс MyCharacter)
Примечание:
Метод equals() сравнивает объекты и возвращает true, если они равны.
Метод compareTo() сравнивает объекты и возвращает 0, если объекты равны,
-1, если вызвавший объект меньше переданного в параметре, и 1, если
вызвавший объект больше переданного в параметре */

public class MyCharacter
{
  private char value;
  
  public MyCharacter(char value) //конструктор с нужным параметром
  {
    this.value=value;
  }
  public char charValue() //возвращение значения
  {
    return value;
  }
  public int compareTo(MyCharacter anotherCharacter) //сравнение объектов(-1, 0, 1)
  {
    Character.compareTo(value, anotherCharacter.value)
  }
  public boolean equals(Object anotherCharacter) //сравнение объектов по булевому значению
  {
    if (anotherCharacter instanceof MyCharacter) //если вместо класса MyCharacter другой объект, то 
    {
      return value == ((MyCharacter)anotherCharacter).value; //возвращает результат сравнения значений, класс anotherCharacter приводится к тому же классу, что и Character
    }
    return false;
  }
  public boolean isDigit() //проверка, числовое ли значение
  {
    return Character.isDigit(value);
  }
  public static boolean isDigit(MyCharacter ch) //проверка, является ли числом(не вызывается)
  {
    return Character.isDigit(ch.charValue());
  }
  public static boolean isLetter(MyCharacter ch) //проверка, является ли буквой(не вызывается)
  {
    return Character.isLetter(ch.charValue());
  }
  public static boolean isLetterOrDigit(MyCharacter ch) //проверка, является ли числом или буквой(не вызывается)
  {
    return Character.isLetterOrDigit(ch.charValue());
  }
}
