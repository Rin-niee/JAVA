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

public class CoolClass {
    private static final int MAX_SIZE = 10;
    private int[] array;
    private int size;

    public CoolClass() {
        array = new int[MAX_SIZE];
        size = 0;
    }

    public void add(int num) throws ContainerFullException {
        if (size == MAX_SIZE) {
            throw new ContainerFullException("Container is full. Cannot add more elements.");
        }
        array[size++] = num;
    }

    public int remove() throws ContainerEmptyException {
        if (size == 0) {
            throw new ContainerEmptyException("Container is empty. Cannot remove element.");
        }
        return array[--size];
    }

    public void sort() throws ContainerEmptyException, AllElementsAreEqualException {
        if (size == 0) {
            throw new ContainerEmptyException("Container is empty. Cannot sort elements.");
        }

        boolean allEqual = true;
        for (int i = 1; i < size; i++) {
            if (array[i] != array[0]) {
                allEqual = false;
                break;
            }
        }

        if (allEqual) {
            throw new AllElementsAreEqualException("All elements in the container are equal. Cannot sort.");
        }

        // реализация метода сортировки элементов
    }

    public int search(int num) throws MultipleElementsFoundException {
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (array[i] == num) {
                count++;
                if (count > 1) {
                    throw new MultipleElementsFoundException("Multiple elements found in the container with value: " + num);
                }
            }
        }

        return count;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++)
        {
            sb.append(array[i]);
            if (i < size - 1)
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
