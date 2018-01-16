package day18;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by deng on 17/11/14.
 *
 * IO异常的处理方式。
 *
 */
public class FileWriterDemo {
    public static void main(String[] args){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("test.txt");
            fileWriter.write("abcde");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileWriter!=null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
