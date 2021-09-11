package IOExample.NIODemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Spaeurs
 * @date: 2021/7/28 10:09
 * @description: NIO 测试服务端
 */
public class NioServer {

    public static void main(String[] args) throws IOException {
        //对应BIO中的ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //轮询器，不同操作系统对应不同的实现类 Windows：select  Linux：epoll
        Selector selector = Selector.open();
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        //将服务端channel注册到轮询器上，并告诉轮询器，自己感兴趣的事件是ACCEPT事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            //调用轮询器的select()方法，是让轮询器从操作系统上获取所有的事件（例如：新客户端的接入、
            // 数据的写入、数据的写出等事件） 参数200代表在操作系统中等待200毫秒，如果没有事件发生就返回
            selector.select(200);
            //调用select()方法后，轮询器将查询到的事件全部放入了selectionKeys中
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //遍历所有事件
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();

                //如果是新连接接入
                if (key.isAcceptable()){
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("有新客户端来连接");
                    socketChannel.configureBlocking(false);
                    //有新客户端接入后，就将客户端对应的channel所感兴趣的事件设置为可读事件
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }

                //如果是可读事件
                if (key.isReadable()){
                    //从channel中读取数据
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    channel.read(byteBuffer);
                    byteBuffer.flip();
                    System.out.println(Charset.defaultCharset().decode(byteBuffer));
                    //读完了以后，再次将channel所感兴趣的事件设置为读事件，方便下次继续
                    //当如果后面要想往客户端写数据，那就注册写事件：SelectionKey.OP_WRITE
                    channel.register(selector,SelectionKey.OP_READ);
                }

                //将key从集合中移除
                iterator.remove();
            }
        }

    }

}