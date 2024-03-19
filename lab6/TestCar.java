import java.util.PriorityQueue;
import java.util.*;

public class TestCar
{
    public static void main(String[] args)
    {
        // Создаем приоритетные очереди с разными компараторами
        PriorityQueue<Car> MedicalPriorityQueue = new PriorityQueue<>(new MedicalPriority());
        PriorityQueue<Car> PolicePriorityQueue = new PriorityQueue<>(new PolicePriority());

        // Добавляем автомобили в очереди
        MedicalPriorityQueue.add(new Car("Medical"));
        MedicalPriorityQueue.add(new Car("Police"));
        MedicalPriorityQueue.add(new Car("Normal"));

        PolicePriorityQueue.add(new Car("Medical"));
        PolicePriorityQueue.add(new Car("Police"));
        PolicePriorityQueue.add(new Car("Normal"));
        System.out.println("===Medical priority===");
        // Извлекаем автомобили из очередей согласно их приоритету
        while (!MedicalPriorityQueue.isEmpty())
        {
            System.out.println(MedicalPriorityQueue.poll().getCarType());
        }
        System.out.println("===Police priority===");
        while (!PolicePriorityQueue.isEmpty())
        {
            System.out.println(PolicePriorityQueue.poll().getCarType());
        }
    }
}
