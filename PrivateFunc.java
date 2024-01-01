public class PrivateFunc {

private class PrivateClass {
private void privateFunc() {
 System.out.println("Hello Java");
   }
}
public void PublicFunc() {
 this.new PrivateClass().privateFunc();
}

 public static void main(String[] args) {
  PrivateFunc MainMethod = new PrivateFunc();
  MainMethod.PublicFunc();
 }
}
