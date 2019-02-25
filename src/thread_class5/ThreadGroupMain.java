package thread_class5;

import com.sun.deploy.util.Waiter;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.nio.file.Watchable;

public class ThreadGroupMain {
    public static void main(String[] args){
        ThreadGroup threadGroup = new ThreadGroup("Seacher");
        Result result = new Result();
        Thread1 thread1 = new Thread1();
        for(int i=0;i<10;i++){

            Thread thread = new Thread(threadGroup,thread1);
            thread.start();
            try {
                thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("=======分割线=======");
        System.out.println("活跃的线程数："+threadGroup.activeCount());
        System.out.println("线程组明细：\n");
        threadGroup.list();
        System.out.println("=======分割线======");

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        System.out.println("=======分割线2=====");
        for(int i=0;i<threadGroup.activeCount();i++){
            System.out.println("thread："+threads[i].getName()+"\n"+threads[i].getState());
        }
        System.out.println("=======分割线2=====");
        //
        if(threadGroup.activeCount()>9) {
            threadGroup.interrupt();
        }
    }
}
