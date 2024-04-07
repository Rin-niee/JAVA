import java.util.Arrays;

public class TestCoolClass
{
    public static void main(String[] args)
    {
        CoolClass coolClass = new CoolClass();

        // Добавление элементов
        try {
            coolClass.add(1);
            coolClass.add(2);
            coolClass.add(3);
            coolClass.add(4);
            coolClass.add(5);
            coolClass.add(1);
            coolClass.add(2);
            coolClass.add(3);
            coolClass.add(4);
            coolClass.add(5);
            coolClass.add(5);
        } catch (ContainerFullException e){
            System.out.println("Контейнер заполнен");
        }

        // Удаление элементов
        try {
            System.out.println("Удаленные элементы: " + coolClass.remove());
            System.out.println("Удаленные элементы: " + coolClass.remove());
            System.out.println("Удаленные элементы: " + coolClass.remove());
        } catch (ContainerEmptyException e){
            System.out.println("Контейнер пуст");
        }
        try
        {
            coolClass.sort();
        }
        catch (ContainerEmptyException | AllElementsAreEqualException e)
        {
          System.out.println("Одинаковые элементы");
        }
        try {
          coolClass.search(1);
        } catch (MultipleElementsFoundException e){
          System.out.println("Есть несколько таких элементов");
        }
        // Печать оставшихся элементов
        System.out.println("Оставшиеся элементы: " + coolClass);
    }
}
