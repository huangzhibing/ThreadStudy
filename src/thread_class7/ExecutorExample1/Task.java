package thread_class7.ExecutorExample1;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.Callable;

public class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("我是线程：" + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
