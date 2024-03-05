public class Pyramid extends Shape
{
  private int a;
  private int b;
  private int h;
  
  public Pyramid(){}
  
  public Pyramid(int a, int b, int h)
  {
    this.a = a;
    this.b = b;
    this.h = h;
  }
  
  public int getWidth()
  {
    return a;
  }
  
  public int setWidth(int a)
  {
    this.a = a;
  }
  
  public int getLength()
  {
    return b;
  }
  
  public int setLength(int b)
  {
    this.b = b;
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
    return (1/3)*a*b*h;
  }
}
