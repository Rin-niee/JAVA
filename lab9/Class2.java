/*Написать программу со следующей функциональностью:
Главный поток программы должен считывать вводимые пользователем строки и
помещать их в конец списка ArrayList. Строки длиннее 80 символов можно разрезать на
несколько строк. Если пользователь вводит пустую строку – программа останавливается и
выводит на консоль текущее состояние списка. Дочерний поток пробуждается каждые
пять секунд и сортирует получившийся список строк в лексикографическом порядке
(используйте любую сортировку). Все операции над списком должны синхронизоваться
при помощи synchronized.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringSorter {

    private static final Object lock = new Object();
    private static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Поток для считывания строк с консоли
        Thread inputThread = new Thread(() -> {
            while (true) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }

                // Разрезаем строки длиннее 80 символов на несколько строк
                if (line.length() > 80) {
                    int startIndex = 0;
                    while (startIndex < line.length()) {
                        int endIndex = Math.min(startIndex + 80, line.length());
                        synchronized (lock) {
                            strings.add(line.substring(startIndex, endIndex));
                        }
                        startIndex = endIndex;
                    }
                } else {
                    synchronized (lock) {
                        strings.add(line);
                    }
                }
            }
        });
        inputThread.start();

        // Поток для сортировки строк
        Thread sortingThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock) {
                    if (!strings.isEmpty()) {
                        Collections.sort(strings);
                        System.out.println("Текущее состояние списка:");
                        for (String string : strings) {
                            System.out.println(string);
                        }
                    }
                }
            }
        });
        sortingThread.start();
    }
}
