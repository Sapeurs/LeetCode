package IOExample.NIODemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: Spaeurs
 * @date: 2021/7/28 11:02
 * @description: NIO 测试 客户端
 */
public class NioClient {

    public static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean connect = socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
        //因为连接是一个异步操作，所以需要判断连接有没有完成，如果连接还没有完成，就进行后面的操作，会出现异常
        if (!connect){
            //如果连接未完成，就等待连接完成
            socketChannel.finishConnect();
        }
        //每隔3秒向服务端发送一条消息
        executorService.scheduleAtFixedRate(()->{
            try {
                String message = socketChannel.getLocalAddress().toString() + " Hello NioServer";
                //使用ByteBuffer进行数据发送
                ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes());
                socketChannel.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        },0,3, TimeUnit.SECONDS);
    }
}