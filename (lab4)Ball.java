public class SolidOfRevolution extends Ball
{
  private int r;
  
  public Ball(){}
  
  public Ball(int r)
  {
    this.r = r;
  }
  
  public int getRadius()
  {
    return r;
  }
  
  public int setRadius(int r)
  {
    this.r = r;
  }
  
  public double getArea()
  {
    return 4*math.PI* (r**2;
  }
}
