package thread_class6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
** 该实例的ReentrantReadWriteLock类里面有读写对应的两个接口函数，通过调用接口函数来调用读/写锁。
** 其中读锁是不会相互排斥的，而写锁会相互排斥。且读-写锁也会相互排斥
**/
public class ReentrantReadWriteLockDemo {

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
            final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
            private Lock readLock = lock.readLock();
            private Lock writeLock = lock.writeLock();
            public void get(){
                try {
                    readLock.lock();//加锁
                    System.out.println("线程："+Thread.currentThread().getName()+"开始read");
                    Thread.sleep(1000);
                    System.out.println("线程："+Thread.currentThread().getName()+"结束read");
                    readLock.unlock();//解锁
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            public void put(){
                try {
                    writeLock.lock();//加锁
                    System.out.println("线程："+Thread.currentThread().getName()+"开始write");
                    Thread.sleep(1000);
                    System.out.println("线程："+Thread.currentThread().getName()+"结束write");
                    writeLock.unlock();//解锁
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

}
