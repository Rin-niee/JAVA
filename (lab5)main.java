import java.util.ArrayList;
import java.util.Collections;

public class Main{
    public static ArrayList<Comparable> maxAndMin(ArrayList<? extends Comparable> list)
    {
        if (list.size() < 2)
        {
            throw new IllegalArgumentException("The input ArrayList must contain at least two elements");
        }

        Collections.sort(list);
        ArrayList<Comparable> result = new ArrayList<>();
        result.add(list.get(list.size() - 1)); // Максимальное значение
        result.add(list.get(0)); // Минимальное значение
        return result;
    }

    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(9);
        numbers.add(1);
        numbers.add(6);
        numbers.add(2);
        System.out.println(maxAndMin(numbers));

        ArrayList<String> strings = new ArrayList<>();
        strings.add("banana");
        strings.add("cherry");
        strings.add("apple");
        strings.add("date");
        System.out.println(maxAndMin(strings));
    }
}
