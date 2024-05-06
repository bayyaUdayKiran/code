public class Test3 {
    
}

public class Shared{
    boolean dataAvailable = false;
    public synchronized void produce(){
        dataAvailable = true;
        notify();   
    }

    public synchronized void consume(){
        while(dataAvailable){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        dataAvailable = false;
    }
}

public class Producer extends Thread{
    Shared sh;
    public Producer(Shared sh){
        this.sh = sh;
    }

    @Override
    public void run(){
        
    }


}
