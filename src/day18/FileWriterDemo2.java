package day18;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by deng on 17/11/14.
 *
 * 演示对已有文件的数据续写。
 */
public class FileWriterDemo2 {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("test.txt", true);
            fw.write("\nhahaha");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}