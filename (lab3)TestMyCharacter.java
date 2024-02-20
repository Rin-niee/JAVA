public class TestMyCharacter
{
  public static void main(String [] args)
  {
    MyCharacter mc1 = new MyCharacter('r');
    MyCharacter mc2 = new MyCharacter('k');
    Object mc2 = new MyCharacter('k');
    System.out.println("Compare To: " + mc1.compareTo(mc2));
    System.out.println("Compare To: " + mc1.equals('b'));
  }
}
