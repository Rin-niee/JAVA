public abstract class SolidOfRevolution extends Shape
{
  private java.util.Date dateCreated;
  private double r;
  public SolidOfRevolution()
  {
    dateCreated = new java.util.Date();
  }
  
  public String toString()
  {
    return "создан: " + dateCreated;
  }
  
  public double getRadius()
  {
    return r;
  }
}
