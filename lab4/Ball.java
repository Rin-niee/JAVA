public class Ball extends SolidOfRevolution
{
  private double r;
  
  public Ball(){}
  
  public Ball(double r)
  {
    this.r = r;
  }
  
  public double getRadius()
  {
    return r;
  }
  
  public double getVolume()
  {
    double Volume;
    Volume = (4/3)*Math.PI*r*r*r;
    return Volume;
  }
  
  
  
  public String toString()
  {
    return "Ball radius: " + r + "/n";
  }
}
