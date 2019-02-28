package thread_class7.ExecutorExample2;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.lang.annotation.Native;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executors = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        List<Future> resultList = new ArrayList<>();

        //设置10个任务
        for(int i=0;i<10;i++){
            SumTask sumTask = new SumTask(i*10+1,(i+1)*10);
            //future类是和task任务相关的：
            //1.调用get()方法获得call函数的返回值
            //2.调用isDone()方法来判断该线程是否结束
            Future result = executors.submit(sumTask);
            resultList.add(result);
        }

        //检查10个任务的完成情况
        do{
            System.out.println("Main：完成的线程个数："+executors.getCompletedTaskCount());
            for(int i=0;i<resultList.size();i++){
                Future<Integer> future = resultList.get(i);
                System.out.println("线程状态："+future.isDone());
                try {
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }while(executors.getCompletedTaskCount()<resultList.size());

        //10个任务都完成之后进行求和
        int total = 0;
        for(int i=0;i<resultList.size();i++){
            Future<Integer> result = resultList.get(i);
            Integer sum = null;
            try {
                sum = result.get();
                total = total + sum;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("1-100的总和是："+total);
    }
}
