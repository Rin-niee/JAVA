/*Написать программу со следующей функциональностью:
Главный поток программы должен считывать вводимые пользователем строки и
помещать их в конец списка ArrayList. Строки длиннее 80 символов можно разрезать на
несколько строк. Если пользователь вводит пустую строку – программа останавливается и
выводит на консоль текущее состояние списка. Дочерний поток пробуждается каждые
пять секунд и сортирует получившийся список строк в лексикографическом порядке
(используйте любую сортировку). Все операции над списком должны синхронизоваться
при помощи synchronized.*/

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        Thread thread = new Thread(new SortThread());
        thread.start();

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Введите строку (длиннее 80 символов автоматически разрезается):");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                synchronized (stringList) {
                    System.out.println("Текущее состояние списка:");
                    for (String str : stringList) {
                        System.out.println(str);
                    }
                    break;
                }
            }

            synchronized (stringList) {
                if (input.length() > 80) {
                    for (int i = 0; i < input.length(); i += 80) {
                        stringList.add(input.substring(i, Math.min(i + 80, input.length())));
                    }
                } else {
                    stringList.add(input);
                }
            }
        }

        scanner.close();
    }

    static class SortThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                    synchronized (stringList) {
                        Collections.sort(stringList);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

