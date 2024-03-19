/* Пусть имеется класс автомобиль. Для каждого автомобиля определен
один из возможных приоритетов – обычный, служебный (полиция),
медицинский.*/

public class Car
{
    private String carType;
    public Car(String carType)
    {
        this.carType = carType;
    }

    public String getCarType()
    {
        return carType;
    }
    public String toString()
    {
      return carType;
    }
}
