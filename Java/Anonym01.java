interface MyFunction {
    void apply(int x);
}

public class Anonym01{
    public static void main(String[] args) {
        // Using an anonymous function to implement the MyFunction interface
        MyFunction func = (int x) -> {
            System.out.println("The value of x is: " + x);
        };
        func.apply(5); // Output: "The value of x is: 5"
    }
}

