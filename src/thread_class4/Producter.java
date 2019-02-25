package thread_class4;

public class Producter implements Runnable{
    private Storage storage;

    public Producter(Storage storage){
        this.storage = storage;
    }
    public void run(){
        int i = 0;

        while(i<10){
            i++;
            Product product = new Product(i,"产品"+i);
            storage.push(product);
        }
    }

}
