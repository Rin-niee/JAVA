public class TestGenericStack
{
    public static void main(String[] args)
    {
        GenericStack<Integer> stack = new GenericStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(43);
        stack.push(90);
        stack.push(61);
        stack.push(3);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Size: " + stack.getSize());
    }
}
