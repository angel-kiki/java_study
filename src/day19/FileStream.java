package day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by deng on 17/11/17.
 *
 * 字符流：
 * FileReader
 * FileWriter
 *
 * 字节流：
 * InputStream  outputStream
 *
 * 需求：想要操作图片数据，这时就要用到字节流。
 */
public class FileStream {
    public static void main(String[] args) throws IOException{
        writeFile();
//        readFile_1();
//        readFile_2();
        readFile_3();
    }

    private static void readFile_3() throws IOException{
        FileInputStream fis = new FileInputStream("testStream.txt");
//        int num = fis.available();
//        System.out.println("num="+num);

        byte[] buf = new byte[fis.available()];//定义一个刚刚好的缓冲区，不用再循环了。
        fis.read(buf);
        System.out.println(new String(buf));

        fis.close();
    }

    private static void readFile_2() throws IOException{
        FileInputStream fis = new FileInputStream("testStream.txt");

        byte[] buf = new byte[1024];
        int len=0;

        while ((len=fis.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }

        fis.close();
    }

    private static void readFile_1() throws IOException{
        FileInputStream fis = new FileInputStream("testStream.txt");

        int ch = 0;

        while ((ch = fis.read())!=-1){
            System.out.println((char)ch);
        }

        fis.close();
    }

    private static void writeFile() throws IOException{
        FileOutputStream fos = new FileOutputStream("testStream.txt");

        fos.write("abcde".getBytes());

        fos.close();
    }
}
