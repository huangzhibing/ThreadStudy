package thread_class6;

import java.util.concurrent.locks.ReentrantLock;
/*
   该实例的reentrantlock显示锁在get和put函数里面并不是公用的，所以肯定都是先“开始”后“结束”，但是，不能保证先“get”在“put”。
*/
public class ReentrantLockDemo {
    public static void main(String[] args) {
        final Count count = new Count();
        for(int i=0;i<2;i++){
            new Thread(){
                @Override
                public void run(){
                    count.get();
                }
            }.start();
        }
        for(int i=0;i<2;i++){
            new Thread(){
                @Override
                public void run(){
                    count.put();
                }
            }.start();
        }
    }

    static class Count{
        public void get(){
            final ReentrantLock lock = new ReentrantLock();
            try {
                lock.lock();//加锁
                System.out.println("线程："+Thread.currentThread().getName()+"开始get");
                Thread.sleep(1000);
                System.out.println("线程："+Thread.currentThread().getName()+"结束get");
                lock.unlock();//解锁
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        public void put(){
            final ReentrantLock lock = new ReentrantLock();
            try {
                lock.lock();//加锁
                System.out.println("线程："+Thread.currentThread().getName()+"开始put");
                Thread.sleep(1000);
                System.out.println("线程："+Thread.currentThread().getName()+"结束put");
                lock.unlock();//解锁
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
