public class MyString2
{
  private char[] chars;
  private int begin;
  private int end;
  private boolean b;
  
  public MyString2(char[] chars)
  {
    this.chars = chars;
  }
  public MyString2 substring(int begin)
  {
    
  }
  public MyString2 substring(int begin, int end)
  {
    
  }
  public boolean equals(Object obj)
  {
     if (obj instanceof MyString2) //если вместо класса MyCharacter другой объект, то 
    {
      return value == ((MyString2)obj).chars; //возвращает результат сравнения значений, класс anotherCharacter приводится к тому же классу, что и Character
    }
    return false;
  }
  public int compareTo(MyString2 obj)
  {
    String.compareTo(chars, obj.value);
  }
  public char[] toChars()
  {
    
  }
  public static MyString2 valueOf(boolean b)
  {
    
  }
}
