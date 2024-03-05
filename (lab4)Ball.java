public class Ball extends Shape
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
  
  public double getVolume()
  {
    return (4/3)*math.PI*r**(3);
  }
}
