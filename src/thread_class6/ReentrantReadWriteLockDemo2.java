package thread_class6;

import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 ** ReentrantReadWriteLock类是在ReentrantLock类的基础上多了读写锁，两者都是显示锁，都要手动加锁和解锁。
 ** ReentrantReadWriteLock可以实现读写分离机制。
 ** 该实例模拟了一个有读有写的场景，仔细体会。
**/
public class ReentrantReadWriteLockDemo2 {

        public static void main(String[] args) {
            final WriteRead writeRead = new WriteRead();
            writeRead.readWrite("0");
            System.out.println("结果："+writeRead.readWrite("0"));
        }

        static class WriteRead{
           private final Map<String,Object> map = new HashMap<String,Object>();
           private final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
           public Object readWrite(String id){
                Object value = null;
                rwlock.readLock().lock(); //开启读锁
               try {
                   value = map.get(id);
                   if(value == null){      //当内存中没有释放读锁
                       rwlock.readLock().unlock();  //开启写锁
                       rwlock.writeLock().lock();
                       try {
                           if(value == null){
                               value = "aaa";   //写入value
                           }
                       }finally {
                           rwlock.writeLock().unlock(); //关闭写锁
                       }
                       rwlock.readLock().lock();    //在上读锁
                   }
               }finally {
                   rwlock.readLock().unlock();      //关闭读锁
               }
               return value;
           }
        }

}
