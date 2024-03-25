import java.util.ArrayList;

public class Box extends Shape
{
  private double volume;
  private ArrayList<Shape> shapesList = new ArrayList<>();
  
   public Box(double volume)
   {
        this.volume = volume;
    }
    
  public boolean add(Shape shape)
  {
        if (shape instanceof SolidOfRevolution)
        {
            double shapeVolume = ((SolidOfRevolution) shape).getVolume();
            if (volume >= shapeVolume)
            {
                shapesList.add(shape);
                volume -= shapeVolume;
                return true;
            }
        }
        return false;
  }
}
