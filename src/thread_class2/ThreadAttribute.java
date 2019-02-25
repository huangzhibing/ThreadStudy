package thread_class2;

public class ThreadAttribute implements Runnable{
    @Override
    public void run(){
        try{
            Thread.sleep(10000L);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    Thread curThread = Thread.currentThread();
    String curThreadName = curThread.getName();
    System.out.println("线程名："+curThreadName);
    System.out.println("线程"+curThreadName+"中活跃的个数："+curThread.getPriority());
    System.out.println("线程"+curThreadName+"标识："+curThread.getId());
    System.out.println("线程"+curThreadName+"状态："+curThread.getState());
    System.out.println("线程"+curThreadName+"所属的组："+curThread.getThreadGroup());
    System.out.println("线程"+curThreadName+"线程是否处于活跃状态："+curThread.isAlive());
    System.out.println("线程"+curThreadName+"线程是否是守护线程："+curThread.isDaemon());
    }
}

