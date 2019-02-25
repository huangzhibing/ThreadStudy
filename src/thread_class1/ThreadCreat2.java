package thread_class1;

public class ThreadCreat2 implements Runnable {

    @Override
    public void run(){
        doSomething();
    }

    public void doSomething(){
        System.out.println("我是第二个线程");
    }
}
