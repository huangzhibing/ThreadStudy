package thread_class3;

import java.nio.channels.NonWritableChannelException;

public class InterruptDemo implements Runnable {
    @Override
    public void run(){
//        try{
//            Thread.sleep(10000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        boolean stop = false;
        while (!stop){
            System.out.println("中断线程正在run");
            long time = System.currentTimeMillis();
            while((System.currentTimeMillis()-time < 1000)){

            }
            //是这样的，main函数并非真的中断了该线程，而是将该线程的中断标志置为true。
            //而对于该线程，可以选择在适当的时机处理这个中断请求，甚至可以不进行处理，就像没被中断一样
            if(Thread.currentThread().isInterrupted()){
                break;
            }
        }
        System.out.println("呵呵呵这才真的关了");
    }

    public static void main(String[] args) throws Exception{

        Thread thread = new Thread(new InterruptDemo(),"被中断的线程");
        System.out.println("线程正在执行");
        thread.start();
        thread.sleep(3000);
        System.out.println("线程正在中断");
        thread.interrupt();
        System.out.println("线程是否被中断:"+thread.isInterrupted());
        thread.sleep(3000);
        System.out.println("线程关闭");
    }
}
