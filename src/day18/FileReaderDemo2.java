package day18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by deng on 17/11/14.
 * 第二种方式：通过字符数组进行读取。
 */
public class FileReaderDemo2 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("test.txt");

            //定义一个字符数组，用于存储读到字符。
            //该read(char[])返回的是读到的字符个数。
            char[] buf = new char[1024];
            int num = 0;
            while ((num=fr.read(buf))!=-1){
                System.out.print(new String(buf,0,num));
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}