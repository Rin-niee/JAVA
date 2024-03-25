import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenericStack1<E> 
{
  private Stack<E> stack;

    public GenericStack()
    {
        stack = new Stack<>();
    }
  
   private java.util.ArrayList<E> list = new java.util.ArrayList<>();
   public int getSize() 
   {
    return list.size();
   }
   public E peek()
  {
    return list.get(getSize() - 1);
   }
   public void push(E o)
   {
    list.add(o);
   }
   
   public E pop()
   {
     E o = list.get(getSize() - 1);
     list.remove(getSize() - 1);
     return o;
   }
   public boolean isEmpty()
   {
    return list.isEmpty();
   }
   public void addWithoutDuplicates(ArrayList<E> elements) {
        for (E element : elements)
        {
            if (!stack.contains(element))
            {
                stack.push(element);
            }
        }
    }
  
   @Override
   public String toString()
   {
    return "стек: " + list.toString();
   }
}
