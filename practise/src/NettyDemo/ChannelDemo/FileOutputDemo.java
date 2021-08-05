package NettyDemo.ChannelDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Spaeurs
 * @date: 2021/8/5 15:51
 * @description:
 * 使用NIO读取数据
 */
public class FileOutputDemo {

    static private final byte[] message = {83, 111, 109, 101, 32, 98, 101, 115};

    public static void main(String[] args) throws Exception {
        FileOutputStream fout = new FileOutputStream("D://test.txt");

        FileChannel fc = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < message.length; i++) {
            buffer.put(message[i]);
        }

        buffer.flip();

        fc.write(buffer);

        fout.close();
    }

}