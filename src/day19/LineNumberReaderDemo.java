package day19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Created by deng on 17/11/16.
 */
public class LineNumberReaderDemo {
    public static void main(String[] args){
        FileReader fr;
        LineNumberReader lnr;
        try {
            fr = new FileReader("javaTest_copy.iml");
            lnr = new LineNumberReader(fr);
            String line = null;
            lnr.setLineNumber(100);
            while ((line=lnr.readLine())!=null){
                System.out.println(lnr.getLineNumber()+":"+line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("文件读入异常");
        }

    }
}


