package day20;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by deng on 17/11/26.
 */
public class SplitFile {
    public static void main(String[] args) throws IOException{
//        splitFile();
        merge();
    }

    public static void merge() throws IOException{
        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();

        for (int x =1;x<=11;x++){
            al.add(new FileInputStream("/Users/deng/Downloads/splitfiles/许巍 - 曾经的你"+x+".part"));
        }

        final Iterator<FileInputStream> it = al.iterator();

        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
            @Override
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            @Override
            public FileInputStream nextElement() {
                return it.next();
            }
        };

        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream("/Users/deng/Downloads/splitfiles/许巍 - 曾经的你.mp3");

        byte[] buf = new byte[1024];
        int len = 0;

        while ((len=sis.read(buf))!=-1){
            fos.write(buf,0,len);
        }

        fos.close();
        sis.close();
    }

    public static void splitFile() throws IOException{
        FileInputStream fis = new FileInputStream("/Users/deng/Downloads/许巍 - 曾经的你.mp3");

        FileOutputStream fos = null;
        byte[] buf = new byte[1024*1024];

        int len = 0;
        int count =1;

        while ((len=fis.read(buf))!=-1){
            fos = new FileOutputStream("/Users/deng/Downloads/splitfiles/许巍 - 曾经的你"+count+++".part");
            fos.write(buf,0,len);
            fos.close();
        }

        fis.close();
    }
}
