package thread_class7.ExecutorExample3;

import thread_class7.ExecutorExample3.Server;
import thread_class7.ExecutorExample3.Task;

import java.io.IOException;
import java.net.*;

import static java.net.InetAddress.getByName;

public class TaskMain2 {

    public static boolean ping(String ipAddress) throws Exception {
        int  timeOut =  300 ;  //超时应该在3钞以上
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);     // 当返回值是true时，说明host是可用的，false则不可。
        return status;
    }

    public static void main(String[] args) throws Exception{
        Server server = new Server();
        do {
            Task task = new Task();
            Thread.sleep(50);
            server.submitTask(task);
        }while(!ping("10.4.12.22"));
//        for(int i=0;i<100;i++){
//            Task task = new Task();
//            Thread.sleep(50);
//            server.submitTask(task);
//        }
    }
}
