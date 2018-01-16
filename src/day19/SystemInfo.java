package day19;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

/**
 * Created by deng on 17/11/21.
 */
public class SystemInfo {
    public static void main(String[] args) throws IOException{
        Properties prop = System.getProperties();

//        System.out.println(prop);
//        prop.list(System.out);
        prop.list(new PrintStream("sysinfo.txt"));
    }
}
