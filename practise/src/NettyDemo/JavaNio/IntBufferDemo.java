package NettyDemo.JavaNio;

import java.nio.IntBuffer;

/**
 * @author: Spaeurs
 * @date: 2021/8/5 14:46
 * @description:
 * 一个使用IntBuffer的例子
 */
public class IntBufferDemo {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(8);
        for (int i = 0; i < buffer.capacity(); i++) {
            int j = 2 * (i+1);
            buffer.put(j);
        }
        //
        IntBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        buffer.flip();

        while (buffer.hasRemaining()){
            int j = buffer.get();
            System.out.println(j + " ");
        }
    }

}