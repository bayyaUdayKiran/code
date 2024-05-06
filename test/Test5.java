import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Test5 {
    public static void main(String[] args) {
        try(FileReader input = new FileReader("passport.jpeg");
        FileWriter output = new FileWriter("passport-copy.jpeg")){

            int data;
            while((data = input.read())!=-1){
                output.write(data);
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
