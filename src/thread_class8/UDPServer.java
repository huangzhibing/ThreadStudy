package thread_class8;

import sun.nio.ch.ThreadPool;

import javax.sound.midi.Receiver;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        boolean runFlag = true;

        String port = "8080";
        DatagramSocket socket = new DatagramSocket(Integer.valueOf(port));
        DatagramPacket packet = null;
        byte[] data = null;
        final int POOL_SIZE = 100;// 单个CPU线程池大小
        LinkedList<String> queue = new LinkedList<String>();


        //为udp接收和插入分别开创线程池
        ThreadPoolExecutor Pool = (ThreadPoolExecutor)(Executors.newCachedThreadPool());
        System.out.println("=====-----start------=====");

        while (runFlag) {
            try {
                data = new byte[1024];
                packet = new DatagramPacket(data,data.length);
                socket.receive(packet);     //一直监听本地收到的数据报

                Pool.execute(new UDPThread(socket,packet,queue));
                Pool.execute(new InsertThread(queue));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
