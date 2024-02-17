public class TestMyTime
{
  public static void main(String [] args)
  {
    MyTime t1= new MyTime();
    MyTime t2 = new MyTime(555550000);
    MyTime t3 = new MyTime(5, 23, 55);
    System.out.println("Текущее время: " + t1);
    System.out.println("Время с 00:00 1 января 1970г: "+ t2);
    System.out.println("Указанное время: " + t3);
  }
}
