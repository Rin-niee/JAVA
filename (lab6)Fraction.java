import java.util.*;

public class Fraction implements Comparable<Fraction> {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public int compareTo(Fraction other) {
        double value1 = (double) this.numerator / this.denominator;
        double value2 = (double) other.numerator / other.denominator;
        return Double.compare(value1, value2);
    }

    public static Comparator<Fraction> ascendingComparator() {
        return Comparator.naturalOrder();
    }

    public static Comparator<Fraction> descendingComparator() {
        return Comparator.reverseOrder();
    }

    public static Comparator<Fraction> absoluteAscendingComparator() {
        return Comparator.comparingDouble(f -> Math.abs((double) f.numerator / f.denominator));
    }

    public static Comparator<Fraction> absoluteDescendingComparator() {
        return Comparator.comparingDouble((Fraction f) -> Math.abs((double) f.numerator / f.denominator)).reversed();
    }

    public static void main(String[] args) {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
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
