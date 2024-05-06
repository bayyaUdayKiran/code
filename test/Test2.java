public class Test2 {
    public static void main(String[] args) {
        Counter count = new Counter();
        Incrementer incrementer = new Incrementer(count);
        //Decrementer decrementer = new Decrementer(count);
        Incrementer incrementer2 = new Incrementer(count);
        
        incrementer.start();
        incrementer2.start();
        //decrementer.start();

        try{
            incrementer.join();
            incrementer2.join();
            //decrementer.join();


        }catch (InterruptedException e) {
            System.err.println("Thread interrupted while waiting for completion");
            e.printStackTrace();
        }
        

        System.out.println(count.getCount());
    }
    
}

class Counter{
    int count = 0;

    public  synchronized void increment(){
        count++;
    }

    public  synchronized void decrement(){
        count--;
    }

    public  int getCount(){
        return count;
    }
}

class Incrementer extends Thread{
    Counter counter;
    public Incrementer(Counter counter){
        this.counter = counter;
        
    }

    @Override
    public void run() {
        for(int i = 0; i<5; i++){
            counter.increment();
        }
    }

    
}

class Decrementer extends Thread{
    Counter counter;
    public Decrementer(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run(){
        for(int i = 0; i<5; i++){
            counter.decrement();
        }
        
    }
}
