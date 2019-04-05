package thread_class8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class UDPThread implements Runnable {
    private volatile LinkedList<String> queue = null;

    public static DatagramSocket socket = null;
    public static DatagramPacket packet = null;

    public UDPThread(DatagramSocket socket,DatagramPacket packet,LinkedList queue){
        UDPThread.socket = socket;
        UDPThread.packet = packet;
        this.queue = queue;
    }

    @Override
    public void run() {
        String info = new String((packet.getData())).trim();
        try {
            queue.push(info);
            System.out.println("成功存入内存");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
