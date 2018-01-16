package day21;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by deng on 17/11/28.
 *
 * 用于操作字节数组的流对象。
 *
 * ByteArrayInputStream：在构造的时候，需要接收数据源，而且数据源是一个字节数组。
 *
 * ByteArrayOutputStream：在构造的时候，不用定义数据目的，因为该对象中已经封装了可变长度的字节数组。这就是数据目的地。
 *
 * 因为这两个流对象都操作的是数组，并没有使用系统资源，所以不用进行close关闭。
 *
 * 流操作：
 * 源设备：键盘 System.in ，硬盘 FileStream，内存 ArrayStream
 * 目的设备：键盘 System.out ，硬盘 FileStream，内存 ArrayStream
 *
 */
public class ByteArrayStream {
    public static void main(String[] args)throws IOException{
        //数据源
        ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEFG".getBytes());

        //数据目的
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int by = 0;

        while ((by = bis.read())!=-1){
            bos.write(by);
        }

        System.out.println(bos.size());
        System.out.println(bos.toString());

        bos.writeTo(new FileOutputStream("tt.txt"));
    }
}
