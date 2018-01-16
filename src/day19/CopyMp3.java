package day19;

import java.io.*;

/**
 * Created by deng on 17/11/20.
 * 演示mp3的复制。通过缓冲区。
 * BufferedOutputStream
 * BufferedInputStream
 */
public class CopyMp3 {
    public static void main(String[] args) throws IOException{
        long start = System.currentTimeMillis();
        copy_1();
//        copy_2();
        long end = System.currentTimeMillis();
        System.out.println((end-start)+"毫秒");
    }

    private static void copy_2() throws IOException{
        MyBufferedInputStream bufis = new MyBufferedInputStream(new FileInputStream("/Users/deng/Downloads/许巍 - 曾经的你.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("/Users/deng/Downloads/许巍 - 曾经的你 - 副本1.mp3"));

        int by = 0;
        while ((by=bufis.myRead())!=-1){
            bufos.write(by);
        }
        bufos.close();
        bufis.myClose();
    }


    //通过字节流的缓冲区完成复制
    private static void copy_1() throws IOException{
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("/Users/deng/Downloads/许巍 - 曾经的你.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("/Users/deng/Downloads/许巍 - 曾经的你 - 副本2.mp3"));

        int by = 0;
        while ((by=bufis.read())!=-1){
            bufos.write(by);
        }
        bufos.close();
        bufis.close();
    }
}
