package thread_class7.ExecutorExample2;

import java.util.Random;
import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer>{
    private int beginNumber;
    private int endNumber;

    public SumTask(int beginNumber,int endNumber){
        this.beginNumber = beginNumber;
        this.endNumber = endNumber;
    }
    @Override
    public Integer call() throws InterruptedException{
         Integer sum = null;

         for(int i=beginNumber;i<=endNumber;i++){
             sum = sum + i;
         }
         Thread.sleep(new Random().nextInt()*1000);
         System.out.println(Thread.currentThread().getName()+"计算结果是："+sum);
         return sum;
    }
}
