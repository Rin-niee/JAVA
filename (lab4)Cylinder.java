public class Cylinder extends Shape
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
  
  public double getVolume()
  {
    return math.PI * (r**2)* h;
  }
  
}
