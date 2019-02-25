package thread_class4;

public class Consumer implements Runnable{
    private Storage storage;

    public Consumer(Storage storage){
        this.storage = storage;
    }

    public void run(){
        int i = 0;

        while(i<10){
            i++;
            storage.pop();
        }
    }
}
