public class This {
    
    private class PrivateClass {
        int n = 5;
    }
    
    public class PublicClass {
        void Output() {
            This.PrivateClass PrivateObject = new This().new PrivateClass();
            PrivateObject.n = 17;
            System.out.println("Value : " + PrivateObject.n);
        }
    }
    
    public static void main(String[] args) {
      This ThisObject = new This();
        ThisObject.new PublicClass().Output();
    }
}