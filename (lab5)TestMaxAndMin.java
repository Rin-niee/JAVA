import java.util.ArrayList;
import java.util.Collections;

public class TestMaxAndMin
{
  public static ArrayList<Comparable> maxAndMin(ArrayList<? extends Comparable> list)
    {
        if (list.size() < 2)
        {
            throw new IllegalArgumentException("Меньше двух элементов в списке");
        }
        Comparable max = Collections.max(list);
        Comparable min = Collections.min(list);

        ArrayList<Comparable> result = new ArrayList<>();
        result.add(max);
        result.add(min);
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
    public static void main(String[] args)
    {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(1);
        intList.add(5);
        intList.add(2);
        System.out.println(maxAndMin(intList));

        ArrayList<MyClass> customList = new ArrayList<>();
        customList.add(new MyClass(4));
        customList.add(new MyClass(0));
        customList.add(new MyClass(5));
        customList.add(new MyClass(9));
        System.out.println(maxAndMin(customList));
    }

    
}
