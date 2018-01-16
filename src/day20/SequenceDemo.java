package day20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by deng on 17/11/26.
 * 多个文件合并成一个文件
 */
public class SequenceDemo {
    public static void main(String[] args)throws IOException{
        Vector<FileInputStream> v = new Vector<FileInputStream>();

        v.add(new FileInputStream("a.txt"));
        v.add(new FileInputStream("aa.txt"));

        Enumeration<FileInputStream> en = v.elements();

        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream("aaa.txt");

        byte[] buf = new byte[1024];

        int len = 0;
        while ((len=sis.read(buf))!=-1){
            fos.write(buf,0,len);
        }
        fos.close();
        sis.close();
    }
}
