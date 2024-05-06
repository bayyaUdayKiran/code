interface MyFunction {
    void apply(int x);
}

public class Anonym04 {
        public static void main(String[] args) {
            // Using an anonymous inner class to implement the MyFunction interface
            MyFunction func = new MyFunction() {
                @Override
                public void apply(int x) {
                    System.out.println("The value of x is: " + x);
                }
            };
            func.apply(5); // Output: "The value of x is: 5"
        }
    }
    
