package day20;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by deng on 17/12/1.
 * 制作一个16M的文件????????????
 */
public class MakeFile {
    public static void main(String[] args){

    }

    public static void makeFile(int n) throws Exception{
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("./src/day20/testfile.txt")));
        byte[] buf = new byte[1024*n];
        for (int i=0;i<buf.length;i++){
            bw.write(i);
        }

    }
}
