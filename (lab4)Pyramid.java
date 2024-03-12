public class Pyramid extends Shape
{
  private double a;
  private double b;
  private double h;
  
  public Pyramid(){}
  
  public Pyramid(double a, double b, double h)
  {
    this.a = a;
    this.b = b;
    this.h = h;
  }
  
  public double getWidth()
  {
    return a;
  }
  
  public double setWidth(double a)
  {
    this.a = a;
  }
  
  public double getLength()
  {
    return b;
  }
  
  public double setLength(double b)
  {
    this.b = b;
  }
  
  public double getHeight()
  {
    return h;
  }
  
  public double setHeight(double r)
  {
    this.h = h;
  }
  
  public double getVolume()
  {
    double Volume; 
    Volume = (1/3)*a*b*h
    return Volume;
  }
  public String toString()
  {
    return "Cylinder weigth: " + a + "Cylinder hight: " + b +  "Cylinder leight: " + c + "/n";
  }
}
