/*Опишите класс с потоковой функцией, выводящей на экран ID потока, а затем с новой
строки – текстовую строку, переданную в конструктор класса (она будет храниться как
поле данных класса, строка должна быть достаточно большой, например, представлять
собой отрывок из известного классического или современного текста). Напишите
программу, которая создаёт несколько потоков (5 - 10). Каждый из созданных потоков
выводит свой текст. При этом вывод текста синхронизирован (следующий текст не
выводится, пока не закончится вывод предыдущего). Этого можно добиться, например,
пометив метод, выводящий текст на консоль как synchronized. */


public class Class1 implements Runnable
{

    private final String text;

    public Class1(String text)
    {
        this.text = text;
    }

    public void run()
    {
        synchronized(System.out)
        {
            System.out.println("Thread ID: " + Thread.currentThread().getId());
            System.out.println(text);
        }
    }
}
