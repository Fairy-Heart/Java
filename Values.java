public class Values {
    
    private int age;
    
    public Values(int publicAge){
        this.age = publicAge;
    }
    
    public static void main(String[] args) {
        Values Object = new Values(17);
        System.out.println(Object.age);
    }
}