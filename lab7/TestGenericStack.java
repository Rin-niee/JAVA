public class TestGenericStack
{
    public static void main(String[] args)
    {
        // Создаем экземпляр GenericStack для хранения целых чисел
        GenericStack<Integer> stack = new GenericStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(43);
        stack.push(90);
        stack.push(61);
        stack.push(3);

        System.out.println("Peek: " + stack.peek());

        // Удаляем верхний элемент стека и выводим его
        System.out.println("Pop: " + stack.pop());

        // Проверяем, пуст ли стек
        System.out.println("Is empty: " + stack.isEmpty());

        // Выводим размер стека
        System.out.println("Size: " + stack.getSize());
    }
}
