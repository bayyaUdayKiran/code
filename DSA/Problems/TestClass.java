import java.util.*;

public class TestClass{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the dimensions of the 2-D matrix: ");
        String dimensionsInput = scanner.nextLine();
        String[] dimensionStrings = dimensionsInput.split(" ");
        int[] dimensions = new int[dimensionStrings.length];
        for (int i = 0; i < dimensionStrings.length; i++) {
            int number = Integer.parseInt(dimensionStrings[i]);
            dimensions[i] = number;
        }

        int rows = dimensions[0];
        int columns = dimensions[1];

        System.out.print("Enter the  2-D matrix: ");
        String matrixInput = scanner.nextLine();
        String[] matrixStrings =matrixInput.split(" ");
        int[] matrix = new int[dimensionStrings.length];
        for (int i = 0; i < dimensionStrings.length; i++) {
            int number = Integer.parseInt(dimensionStrings[i]);
            dimensions[i] = number;
        }
        

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){

            }
        }
        
        
    }
    
}