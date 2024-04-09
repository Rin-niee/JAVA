public class TestClass1
{
   public static void main(String[] args)
   {
        String[] texts ={
            "Hehe",
            "Not hehe",
            "Okay",
            "WOW",
            "Well...",
            "I think so",
            "Meow"
        };

        for (String text : texts)
        {
            new Thread(new Class1(text)).start();
        }
    }

}
