package day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by deng on 17/11/17.
 *
 * 复制一个图片
 * 思路：
 * 1，用字节读取流对象和图片关联。
 * 2，用字节写入流对象创建一个图片文件，用于存储获取到的图片数据。
 * 3，通过循环读写，完成数据的存储。
 * 4，关闭资源。
 */
public class CopyPic {
    public static void main(String[] args){
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fos = new FileOutputStream("cd1.jpg");
            fis = new FileInputStream("cd.jpeg");

            byte[] buf = new byte[1024];

            int len = 0;

            while ((len=fis.read(buf))!=-1){
                fos.write(buf,0,len);
            }
        }catch (IOException e){
            throw new RuntimeException("复制文件失败");
        }finally {
            try {
                if (fis!=null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException("关闭读取文件失败");
            }

            try {
                if (fos!=null)
                    fos.close();
            } catch (IOException e) {
                throw new RuntimeException("关闭写入文件失败");
            }
        }
    }
}
