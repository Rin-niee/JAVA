/*Разработать класс-контейнер для хранения целых чисел. Данные должны
храниться в виде массива, ограниченном максимальным размером (например,
10 элементов). Реализовать методы добавления данных и удаления данных
(например, по принципу стека). Методы должны генерировать исключение
при попытке добавить данное в уже заполненный контейнер и удалить из
пустого контейнера. Для этого создать свои классы исключений.
Кроме этого реализовать один из следующих методов (на выбор):
Вариант 1
~ сортировки элементов. Метод генерирует исключение при попытке
сортировать пустой контейнер или если все его элементы - равны;
Вариант 2
~ поиска элементов по значению. Метод генерирует исключение, если
контейнер содержит больше одного искомого элемента.*/

import java.util.Arrays;

public class IntContainer {
    private int[] data;
    private int size;
    private static final int MAX_SIZE = 10;

    public IntContainer() {
        this.data = new int[MAX_SIZE];
        this.size = 0;
    }

    public void add(int value) throws ContainerFullException {
        if (size == MAX_SIZE) {
            throw new ContainerFullException("Container is full");
        }
        data[size++] = value;
    }

    public int remove() throws ContainerEmptyException {
        if (size == 0) {
            throw new ContainerEmptyException("Container is empty");
        }
        return data[--size];
    }

    public void sort() throws ContainerEmptyException, ContainerAllEqualException {
        if (size == 0) {
            throw new ContainerEmptyException("Container is empty");
        }
        if (isAllEqual()) {
            throw new ContainerAllEqualException("All elements are equal");
        }
        Arrays.sort(data, 0, size);
    }

    public int find(int value) throws ContainerMultipleValuesException {
        int count = 0;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                count++;
                index = i;
            }
        }
        if (count > 1) {
            throw new ContainerMultipleValuesException("Multiple values found");
        }
        return index;
    }

    private boolean isAllEqual() {
        for (int i = 1; i < size; i++) {
            if (data[i] != data[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static class ContainerFullException extends RuntimeException {
        public ContainerFullException(String message) {
            super(message);
        }
    }

    public static class ContainerEmptyException extends RuntimeException {
        public ContainerEmptyException(String message) {
            super(message);
        }
    }

    public static class ContainerAllEqualException extends RuntimeException {
        public ContainerAllEqualException(String message) {
            super(message);
        }
    }

    public static class ContainerMultipleValuesException extends RuntimeException {
        public ContainerMultipleValuesException(String message) {
            super(message);
        }
    }
}
