public class TestMyStack
{
    public static void main(String[] args)
    {
        MyStack stack1 = new MyStack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        System.out.println("stack1: " + stack1.toString());

        MyStack stack2 = (MyStack) stack1.clone();

        System.out.println("stack1 isEmpty: " + stack1.isEmpty());
        System.out.println("stack2 isEmpty: " + stack2.isEmpty());

        stack1.pop();
        System.out.println("stack1: " + stack1.toString());
        System.out.println("stack2: " + stack2.toString());
    }
}
