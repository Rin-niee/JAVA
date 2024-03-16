import java.util.PriorityQueue;

// Класс автомобиль
class Car {
    private String carType;

    public Car(String carType) {
        this.carType = carType;
    }

    public String getCarType() {
        return carType;
    }
}

// Компараторы для определения приоритета автомобилей
class HighestMedicalPriorityComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getCarType().equals("Medical") && !car2.getCarType().equals("Medical")) {
            return -1; // Car1 has higher priority
        } else if (!car1.getCarType().equals("Medical") && car2.getCarType().equals("Medical")) {
            return 1; // Car2 has higher priority
        } else {
            return 0; // Equal priority
        }
    }
}

class HighestPolicePriorityComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getCarType().equals("Police") && !car2.getCarType().equals("Police")) {
            return -1; // Car1 has higher priority
        } else if (!car1.getCarType().equals("Police") && car2.getCarType().equals("Police")) {
            return 1; // Car2 has higher priority
        } else {
            return 0; // Equal priority
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем приоритетные очереди с разными компараторами
        PriorityQueue<Car> highestMedicalPriorityQueue = new PriorityQueue<>(new HighestMedicalPriorityComparator());
        PriorityQueue<Car> highestPolicePriorityQueue = new PriorityQueue<>(new HighestPolicePriorityComparator());

        // Добавляем автомобили в очереди
        highestMedicalPriorityQueue.add(new Car("Medical"));
        highestMedicalPriorityQueue.add(new Car("Police"));
        highestMedicalPriorityQueue.add(new Car("Normal"));

        highestPolicePriorityQueue.add(new Car("Medical"));
        highestPolicePriorityQueue.add(new Car("Police"));
        highestPolicePriorityQueue.add(new Car("Normal"));

        // Извлекаем автомобили из очередей согласно их приоритету
        while (!highestMedicalPriorityQueue.isEmpty()) {
            System.out.println(highestMedicalPriorityQueue.poll().getCarType());
        }

        while (!highestPolicePriorityQueue.isEmpty()) {
            System.out.println(highestPolicePriorityQueue.poll().getCarType());
        }
    }
}
