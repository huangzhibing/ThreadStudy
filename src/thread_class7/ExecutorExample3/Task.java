package thread_class7.ExecutorExample3;

import java.awt.*;
import java.io.IOException;

public class Task implements Runnable{
    @Override
    public void run(){
        try{
            String url = "http://10.4.12.22/SERVER/";
            java.net.URI uri = java.net.URI.create(url);
            Desktop desktop = Desktop.getDesktop();
            if(desktop.isSupported(Desktop.Action.BROWSE)){
                desktop.browse(uri);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
