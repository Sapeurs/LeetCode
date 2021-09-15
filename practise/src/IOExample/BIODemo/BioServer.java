package IOExample.BIODemo;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Spaeurs
 * @date: 2021/7/27 16:40
 * @description: BIO 服务端测试
 * <p>
 * 无法同时接受两个客户端的连接
 */
public class BioServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            //accept()方法是一个阻塞方法，如果没有客户端连接，线程就会一直阻塞在这儿
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            //read()方法是一个阻塞方法，当没有数据可读时，线程就会一直阻塞在read()方法上
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len));
            }
        }
    }
}