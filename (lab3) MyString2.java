/*Java-библиотека предоставляет класс String. Предоставьте собственную
реализацию следующих методов (назовите новый класс MyString2):
public MyString2(char[] chars);
public MyString2 substring(int begin);
public MyString2 substring(int begin, int end);
public boolean equals(Object obj);
public int compareTo(MyString2 obj);
public char[] toChars();
public static MyString2 valueOf(boolean b);*/

import java.util.Arrays;

public class MyString2
{
  public char[] chars;
  
  public MyString2(char[] chars)
  {
    this.chars = chars;
  }
  public MyString2 substring(int begin)
  {
    return new MyString2(Arrays.copyOfRange(chars, begin, chars.length));
   
  }
  public MyString2 substring(int begin, int end)
  {
     return new MyString2(Arrays.copyOfRange(chars, begin, end));
  }
  public boolean equals(Object obj)
  {
     if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MyString2 other = (MyString2) obj;
        return Arrays.equals(chars, other.chars);
  }
  public int compareTo(MyString2 obj)
  {
    return String.valueOf(chars).compareTo(String.valueOf(obj.chars));
    }
  public char[] toChars()
  {
      return chars;
  }
  public static MyString2 valueOf(boolean b)
  {
    return new MyString2(String.valueOf(b).toCharArray());
    
  }
  public String toString() {
        return String.valueOf(chars);
    }
}
