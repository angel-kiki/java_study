package day19;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by deng on 17/11/20.
 * 读取键盘录入。
 * System.out：对应的是标准输出设备：控制台。
 * System.in：对应的标准输入设备：键盘
 *
 * 需求：
 * 通过键盘录入数据。
 * 当录入一行数据后，就将改行数据进行打印。
 * 如果录入的数据是over，那么停止录入。
 */
public class ReadIn {
    public static void main(String[] args) throws IOException{
        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();

        while (true){
            int ch = in.read();
            if (ch=='\r')
                continue;
            if (ch=='\n'){
                String s = sb.toString();
                if ("over".equals(s.toLowerCase()))
                    break;
                System.out.println(s.toUpperCase());
                sb.delete(0,sb.length());
            }else
                sb.append((char) ch);
        }
    }
}
