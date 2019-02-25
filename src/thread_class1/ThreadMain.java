package thread_class1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadMain {
    public static void main(String[] args) {
        //第一种创建线程的方法
        ThreadCreat1 thread1 = new ThreadCreat1();
        thread1.start();


        //第二种创建线程的方法
        ThreadCreat2 thread2 = new ThreadCreat2();
        Thread thread = new Thread(thread2);
        thread.start();


        //第三种创建线程的方法
        Callable<Integer> callable = new ThreadCreat3();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        Thread thread3 = new Thread(futureTask);
        thread3.start();

        try {
            System.out.println(futureTask.get());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
