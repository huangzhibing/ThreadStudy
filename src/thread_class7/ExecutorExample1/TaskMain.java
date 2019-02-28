package thread_class7.ExecutorExample1;

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
