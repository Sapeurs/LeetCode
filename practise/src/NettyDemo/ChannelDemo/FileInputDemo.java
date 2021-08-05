package NettyDemo.ChannelDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Spaeurs
 * @date: 2021/8/5 16:03
 * @description:
 * 使用NIO写入数据
 */
public class FileInputDemo {
    public static void main(String[] args) throws Exception {
        FileInputStream fin = new FileInputStream("D://test.txt");
        FileChannel fc = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(10);
        fc.read(buffer);
        buffer.flip();
        while (buffer.remaining()>0){
            byte b = buffer.get();
            System.out.println((char) b);
        }
        fin.close();
    }
}