import java.util.ArrayList;

public class MyStack<T extends Comparable<T>> {
    private ArrayList<T> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public T peek() {
        return list.get(getSize() - 1);
    }

    public T pop() {
        T o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(T o) {
        list.add(o);
    }

    public void sort() {
        list.sort(Comparable::compareTo);
    }

    @Override
    /** Переопределяет метод toString класса Object */
    public String toString() {
        return "стек: " + list.toString();
    }
}
