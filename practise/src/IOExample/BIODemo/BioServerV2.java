package IOExample.BIODemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Spaeurs
 * @date: 2021/7/27 17:09
 * @description: BIO 服务端测试 第二版
 *
 * 可以两个客户端同时连接
 * 缺点：每当有一个新客户端来连接时，都需要为这个客户端创建一个线程来处理读数据的操作
 *
 */
public class BioServerV2 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true){
            //accept()方法是一个阻塞方法，如果没有客户端连接，线程就会一直阻塞在这儿
            Socket accept = serverSocket.accept();
            handleMessage(accept);
        }
    }

    private static void handleMessage(Socket socket){
        //新创建一个线程来读取数据，不回造成main线程阻塞在read方法上
        new Thread(()->{
            try {
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len;
                //read()方法是一个阻塞方法，当没有数据可读时，线程就会一直阻塞在read()方法上
                while ((len = inputStream.read(bytes))!=-1){
                    System.out.println(new String(bytes,0,len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}