package thread_class5;

public class Thread1 implements Runnable {

    private Result result;

    public void getResult(Result result){
        this.result = result;
    }
    public void run(){
        String name = Thread.currentThread().getName();
        System.out.println("启动线程"+name);
        long time = System.currentTimeMillis();
        while(true){
            try {
                Thread.sleep(10000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("======++++++======");
        }
    }
}
