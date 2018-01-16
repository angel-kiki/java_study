package day19;

import java.io.*;

/**
 * Created by deng on 17/11/21.
 * 改变源和目的
 */
public class TransStreamDemo3 {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("javaTest_copy.iml"));

        System.setOut(new PrintStream("aa.txt"));

        //键盘录入最常用的写法
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;

        while ((line=bufr.readLine())!=null){
            if ("over".equals(line.toLowerCase()))
                break;
//            System.out.println(line.toUpperCase());
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }
        bufr.close();
    }
}
