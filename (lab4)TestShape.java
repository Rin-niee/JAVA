public class TestShape{
  public class Main {
      public static void main(String[] args) {
          Box box = new Box(1000);
  
          Sphere sphere = new Sphere(5);
          Cylinder cylinder = new Cylinder(4, 10);
  
          System.out.println("Adding sphere: " + box.add(sphere));
          System.out.println("Adding cylinder: " + box.add(cylinder));
          System.out.println(box);
      }
  }
