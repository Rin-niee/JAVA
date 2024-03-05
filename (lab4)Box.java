import java.util.ArrayList;

public class Box extends Shape
{
  private double volume;
  private ArrayList<Shape> list = new ArrayList<>();
   public Box(double volume) {
        this.volume = volume;
    }
  public boolean add(Shape shape) {
        if (shape instanceof SolidOfRevolution) {
            double shapeVolume = ((SolidOfRevolution) shape).getVolume();
            if (volume >= shapeVolume) {
                shapesList.add(shape);
                volume -= shapeVolume;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Box { volume: ").append(volume).append(", shapes: ");
        for (Shape shape : shapesList) {
            sb.append(shape.toString()).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(" }");
        return sb.toString();
    }
}
