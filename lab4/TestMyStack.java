public class testMyStack{
   public static void main(String[] args) {
        MyStack<Integer> intStack = new MyStack<>();
        intStack.push(3);
        intStack.push(1);
        intStack.push(2);
        System.out.println("До сортировки: " + intStack.toString());
        intStack.sort();
        System.out.println("После сортировки: " + intStack.toString());

        MyStack<String> stringStack = new MyStack<>();
        stringStack.push("b");
        stringStack.push("a");
        stringStack.push("c");
        System.out.println("До сортировки: " + stringStack.toString());
        stringStack.sort();
        System.out.println("После сортировки: " + stringStack.toString());
    }
}
