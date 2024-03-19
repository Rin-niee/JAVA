/*Опишите класс Fraction, представляющий собой обыкновенную дробь: класс
включает в себя целые элементы-данные numerator (числитель) и
denominator (знаменатель). Реализуйте в классе интерфейс Comparable, так,
чтобы можно было упорядочивать дроби по возрастанию.
Реализуйте компаратор для упорядочивания дробей так, чтобы можно было
бы упорядочивать дроби одним из четырёх способов: по возрастанию, по
убыванию, по возрастанию абсолютных значений, по убыванию абсолютных
значений.
Продемонстрируйте работу функционала на примере сортировки дробей
методом Collections.sort().
*/

import java.util.*;

public class Fraction implements Comparable<Fraction>
{
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public int compareTo(Fraction other)
    {
        double value1 = (double) this.numerator / this.denominator;
        double value2 = (double) other.numerator / other.denominator;
        return Double.compare(value1, value2);
    }

    public static Comparator<Fraction> ascendingComparator()
    {
        return Comparator.naturalOrder();
    }

    public static Comparator<Fraction> descendingComparator()
    {
        return Comparator.reverseOrder();
    }

    public static Comparator<Fraction> absoluteAscendingComparator()
    {
        return Comparator.comparingDouble(f -> Math.abs((double) f.numerator / f.denominator));
    }

    public static Comparator<Fraction> absoluteDescendingComparator()
    {
        return Comparator.comparingDouble((Fraction f) -> Math.abs((double) f.numerator / f.denominator)).reversed();
    }
   public String toString(){
      return numerator + "/" + denominator;
    }
}
