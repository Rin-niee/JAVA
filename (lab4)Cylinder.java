public class SolidOfRevolution extends Cylinder
{
  private int r;
  private int h;
  
  public Cylinder(){}
  
  public Cylinder(int r, int h)
  {
    this.r = r;
    this.h = h;
  }
  
  public int getRadius()
  {
    return r;
  }
  
  public int setRadius(int r)
  {
    this.r = r;
  }
  public int getHeight()
  {
    return h;
  }
  
  public int setHeight(int r)
  {
    this.h = h;
  }
  
  public double getArea()
  {
    return 2*math.PI* (r**2)+ 2*math.PI*h;
  }
  public double getPerimeter()
  {
    return 2*(2*math.PI*r+h);
  }
  
}
