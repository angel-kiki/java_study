package day19;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by deng on 17/11/21.
 */
public class ExceptionInfo {
    public static void main(String[] args){
        try {
            int[] arr = new int[2];
            System.out.println(arr[3]);
        }catch (Exception e){
            try {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String s = sdf.format(d);

                PrintStream ps = new PrintStream("exception.log");
                ps.println(s);
                System.setOut(ps);
            }catch (IOException ex){
                throw new RuntimeException("日志文件创建失败");
            }
            e.printStackTrace(System.out);
        }
    }
}
