package thread_class7.ExecutorExample1;

import thread_class7.ExecutorExample1.Server;
import thread_class7.ExecutorExample1.Task;

public class TaskMain {
    public static void main(String[] args) throws InterruptedException{
        Server server = new Server();
        for(int i=0;i<100;i++){
            Task task = new Task();
            Thread.sleep(50);
            server.submitTask(task);
        }
        server.endServer();
    }
}
