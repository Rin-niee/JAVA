import java.util.*;
import java.util.PriorityQueue;

public class MedicalPriority implements Comparator<Car>
{
    public int compare(Car car1, Car car2)
    {
        if (car1.getCarType().equals("Medical") && !car2.getCarType().equals("Medical"))
        {
            return -1; // Car1 has higher priority
        } 
        else if (!car1.getCarType().equals("Medical") && car2.getCarType().equals("Police"))
        {
            return 1; // Car2 has higher priority
        }
        else
        {
            return 0; // Equal priority
        }
    }
}
