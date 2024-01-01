public class Static {
 
 public static class Sub {
  public void sub() {
   System.out.println("Hello from non-static func");
  }
 }
 
 public static void main(String[] args) {
  Static MainMethod = new Static();
  Sub SubMethod = MainMethod.new Sub();
  SubMethod.sub();
   }
 }