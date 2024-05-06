
public class Test{
    public static void main(String[] args) {
        InvalidInput inp = new InvalidInput();
        try{
            inp.func(-2);
        }catch(InvalidInputException e) {
            System.out.println(e.getMessage());

        }finally{
            System.out.println("Program Terminated");
        }
        
    }

    
}


class InvalidInputException extends Exception{
    InvalidInputException(String msg){
        super(msg);
    }
}

class InvalidInput{
    public void func(int n) throws InvalidInputException{
        if(n<0){
            throw new InvalidInputException("Invalid input integer");
        }
    }

}



