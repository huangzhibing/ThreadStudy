package thread_class1;

public class ThreadCreat1 extends Thread{

    @Override
    public void run(){
        doSomething();
    }

    public void doSomething(){
        System.out.println("我是第一个线程");
    }

}
