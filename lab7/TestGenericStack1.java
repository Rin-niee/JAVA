import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestGenericStack 
{
  public static void main(String[] args) {
        // Пример использования
        GenericStack<Integer> stack = new GenericStack<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2); // Дубликат
        list.add(4);
        list.add(3); // Дубликат

        stack.addWithoutDuplicates(list);

        // Вывод стека после добавления без дубликатов
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
