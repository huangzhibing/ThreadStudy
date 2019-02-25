package thread_class1;

import java.util.concurrent.Callable;

public class ThreadCreat3 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception{
        doSomething();
        return 250;
    }

    public void doSomething(){
        System.out.println("我是第三个线程");
    }
}
