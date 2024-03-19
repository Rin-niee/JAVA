import java.util.*;

public class TestFraction
{
    public static void main(String[] args)
    {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(2, 2));
        fractions.add(new Fraction(3, 4));
        fractions.add(new Fraction(1, 3));

        Collections.sort(fractions); // сортировка по возрастанию

        System.out.println("Сортировка по возрастанию: " + fractions);

        Collections.sort(fractions, Fraction.descendingComparator()); // сортировка по убыванию

        System.out.println("Сортировка по убыванию: " + fractions);

        Collections.sort(fractions, Fraction.absoluteAscendingComparator()); // сортировка по возрастанию абсолютных значений

        System.out.println("Сортировка по возрастанию абсолютных значений: " + fractions);

        Collections.sort(fractions, Fraction.absoluteDescendingComparator()); // сортировка по убыванию абсолютных значений

        System.out.println("Сортировка по убыванию абсолютных значений: " + fractions);
    }
}
