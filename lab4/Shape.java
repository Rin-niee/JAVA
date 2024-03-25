public abstract class Shape
{
  private java.util.Date dateCreated;
  private double Volume;
  public Shape()
  {
    dateCreated = new java.util.Date();
  }
  
  public String toString()
  {
    return "создан: " + dateCreated;
  }

  public double getVolume()
  {
    return Volume;
  }
}
