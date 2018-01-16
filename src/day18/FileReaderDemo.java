package day18;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by deng on 17/11/14.
 */
public class FileReaderDemo {
    public static void main(String[] args) {
        //创建一个文件读取流对象，和指定名称的文件相关联。
        //要保证该文件是已经存在的，如果不存在，会发生异常FileNotFoundException
        FileReader fr = null;
        try {
            fr = new FileReader("test.txt");

            //调用读取流对象的read方法。
            //read()：一次读一个字符，而且会自动往下读。
            int ch = 0;
            while ((ch = fr.read())!=-1){
                System.out.print((char)ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}