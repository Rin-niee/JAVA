/*Возьмите класс-дженерик класс GenericStack из варианта 1. Напишите метод,
которому передается коллекция объектов типа ArrayList и добавляется в
конец стека, но так, чтобы отбрасывались значения-дубликаты. Для поиска и
удаления дубликатов необходимо использовать метод contains() интерфейса
List.*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenericStack<E>
{
   private java.util.ArrayList<E> list = new java.util.ArrayList<>();
   private  java.util.Stack<E> stack = new java.util.Stack<>();
   //новый стек
   public GenericStack()
    {
        stack = new Stack<>();
    }
    
   //получить размер стека
   public int getSize()
   {
      return list.size();
   }
   
   //узнать что находится в конце стека
   public E peek()
   {
      return list.get(getSize() - 1);
   }
   //добавить в стек число
   public void push(E o)
   {
      list.add(o);
   }
   
   //вывести и удалить число в стеке
   public E pop()
   {
     E o = list.get(getSize() - 1);
     list.remove(getSize() - 1);
     return o;
   }
   
   //проверка пустой ли стек
   public boolean isEmpty()
   {
      return list.isEmpty();
   }
   //по плану сортировка
   public void addWithoutDuplicates(ArrayList<E> elements)
   {
     
        for (E element : elements)
        {
            if (!list.contains(element))
            {
                list.add(element);
            }
        }
    }
  
  //стринг ту стринг
   @Override
   public String toString(){
   return "стек: " + list.toString();
   }
}
