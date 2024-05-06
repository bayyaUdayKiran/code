public class Test4 {
   
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>(25);
        Box<String> strBox = new Box<>("Uday");
        System.out.println(intBox.getValue());
        System.out.println(strBox.getValue());

        System.out.println(intBox.returner("accio"));


        
        
    }

   
    

    
}

class Box<T>{
    T value;
    public Box(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public <T> T returner(T n){
        return n;
    }
}
