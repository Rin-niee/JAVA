public class TestShape{
      public static void main(String[] args)
      {
          Box box = new Box(10000);
  
          Ball sphere = new Ball(5);
          Cylinder cylinder = new Cylinder(4, 10);
          Pyramid pyramid = new Pyramid(4, 10, 15);
          
  
          System.out.println("Adding sphere: " + box.add(sphere));
          System.out.println("Adding cylinder: " + box.add(cylinder));
          System.out.println("Adding pyramid: " + box.add(pyramid));
          System.out.println(box);
      }
  }
