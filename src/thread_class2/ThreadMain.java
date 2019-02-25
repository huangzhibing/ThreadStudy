package thread_class2;

import thread_class1.ThreadCreat2;

public class ThreadMain {
    public static void main(String[] args) {
        ThreadAttribute thread = new ThreadAttribute();
        //可以看到五个线程并发执行的时候是没有顺序的，都是按照操作系统的安排来执行的
        for(int i=0;i<5;i++){
            new Thread(thread,"线程"+i).start();
        }
        Thread threadMain = Thread.currentThread();
        String curThreadName = threadMain.getName();
        System.out.println("线程名："+curThreadName);
        System.out.println("线程"+curThreadName+"中活跃的个数："+threadMain.getPriority());
        System.out.println("线程"+curThreadName+"标识："+threadMain.getId());
        System.out.println("线程"+curThreadName+"状态："+threadMain.getState());
        System.out.println("线程"+curThreadName+"所属的组："+threadMain.getThreadGroup());
        System.out.println("线程"+curThreadName+"线程是否处于活跃状态："+threadMain.isAlive());
        System.out.println("线程"+curThreadName+"线程是否是守护线程："+threadMain.isDaemon());

    }
}
