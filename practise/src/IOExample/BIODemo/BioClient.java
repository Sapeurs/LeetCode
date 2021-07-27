package IOExample.BIODemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: Spaeurs
 * @date: 2021/7/27 16:49
 * @description: BIO 测试 客户端
 */
public class BioClient {

    //新建一个具有定时执行任务功能的线程池
    public static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        //采用具有定时执行任务的线程池模拟客户端每隔3s来向服务端发送消息
        executorService.scheduleAtFixedRate(()->{
            try {
                OutputStream outputStream = socket.getOutputStream();
                //向服务端发送消息
                String message = socket.getLocalSocketAddress().toString() + " Hello Server";
                outputStream.write(message.getBytes());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        },0,3, TimeUnit.SECONDS);
    }

}