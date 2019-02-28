package thread_class7.ExecutorExample1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {
    //线程池
    private ThreadPoolExecutor executor;

    public Server(){
        executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();     //动态线程池
        //executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(8);   //规定线程个数的线程池
    }

    public void submitTask(Task task){
        System.out.println("+++++++++==========++++++++++");
        System.out.println("一个新的任务来了");
        executor.execute(task);
        System.out.println("线程池的大小："+executor.getPoolSize());
        System.out.println("线程池的活跃个数："+executor.getActiveCount());
        System.out.println("线程池的完成个数："+executor.getCompletedTaskCount());
    }

    public void endServer(){
        executor.shutdown();
    }
}
