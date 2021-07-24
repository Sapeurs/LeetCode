package IOPractise;

import java.io.*;

/**
 * @author: Sapeurs
 * @date: 2021/5/7 20:08
 * @description: 使用IO流复制文件或图片
 */
public class FileCopy {

    public static void main(String[] args) {
        //被复制的文件
        File fromFile = new File("D:/File/miaosha.sql");
        //复制出来的文件
        File toFile = new File("D:/File/Second.sql");
        //声明输入流
        InputStream is = null;
        //声明输出流
        OutputStream os;

        try {
            is = new FileInputStream(fromFile);//创建输入流
            os = new FileOutputStream(toFile);//创建输出流
            //逐个字节读取
            int content = is.read();
            while (content != -1) {
                //使用输出流将读到的content写入到文件
                os.write(content);
                //刷新流
                os.flush();
                content = is.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("文件复制完成");
        }
    }
}