public class nonStatic {
 
 public class Sub {
  public void sub() {
   System.out.println("Hello from non-static function");
  }
 }
 
 public static void main(String[] args) {
  nonStatic MainMethod = new nonStatic();
  Sub SubMethod = MainMethod.new Sub();
  SubMethod.sub();
  }  
 }