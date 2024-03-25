public class Cylinder extends SolidOfRevolution
{
  private double r;
  private double h;
  
  public Cylinder(){}
  
  public Cylinder(double r, double h)
  {
    this.r = r;
    this.h = h;
  }
  
  public double getRadius()
  {
    return r;
  }
  
  public double getHeight()
  {
    return h;
  }
  
  public double getVolume()
  {
    double Volume;
    Volume = Math.PI * (r*r)* h;
    return Volume;
  }
  public String toString()
  {
    return "Cylinder radius: " + r + "Cylinder hight: " + h + "/n";
  }
  
}
