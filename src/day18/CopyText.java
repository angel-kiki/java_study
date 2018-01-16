package day18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by deng on 17/11/14.
 *
 * 需求：将C盘一个文本文件复制到D盘
 *
 * 复制的原理：
 * 其实就是讲C盘下的文件数据存储到D盘的一个文件中。
 *
 * 步骤：
 * 1，在D盘创建一个文件。用于存储C盘文件中的数据。
 * 2，定义读取流和C盘文件关联。
 * 3，通过不断的读写完成数据存储。
 * 4，关闭资源
 */
public class CopyText {
    public static void main(String[] args) {
//        copy_1();
        copy_2();
    }

    private static void copy_2() {
        FileWriter fw = null;
        FileReader fr = null;

        try {
            //创建目的地。
            fw = new FileWriter("javaTest_copy.iml");
            //与已有文件关联
            fr = new FileReader("javaTest.iml");
            char[] buf = new char[1024];
            int len = 0;

            while ((len = fr.read(buf))!=-1){
                fw.write(buf,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException("读写失败");
        }finally {
            if (fr!=null)
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            if (fw!=null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    //从C盘读一个字符，就往D盘写一个字符。
    private static void copy_1() {
        FileWriter fw = null;
        FileReader fr = null;
        try {
            //创建目的地。
            fw = new FileWriter("javaTest_copy.iml");
            //与已有文件关联
            fr = new FileReader("javaTest.iml");
            int ch = 0;
            while ((ch = fr.read())!=-1){
                fw.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw!=null)
                    fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (fr!=null)
                        fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}