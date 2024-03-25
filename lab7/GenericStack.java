import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericStack<E>
{
    private static final int DEFAULT_CAPACITY = 10;
    private E[] arr;
    private int size;

    public GenericStack() {
        arr = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int getSize()
    {
        return size;
    }

    public E peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return arr[size - 1];
    }

    public void push(E o)
    {
        if (size == arr.length)
        {
            ensureCapacity();
        }
        arr[size++] = o;
    }

    public E pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        E o = arr[--size];
        arr[size] = null; // dereference to help garbage collection
        return o;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private void ensureCapacity()
    {
        int newSize = arr.length * 2;
        arr = Arrays.copyOf(arr, newSize);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("стек: [");
        for (int i = 0; i < size; i++)
        {
            sb.append(arr[i]);
            if (i < size - 1)
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
