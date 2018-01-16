package day19;


import java.io.IOException;
import java.io.InputStream;

/**
 * Created by deng on 17/11/20.
 */
public class MyBufferedInputStream {
    private InputStream in;

    private int pos = 0,count = 0;
    byte[] buf = new byte[1024*4];
    MyBufferedInputStream(InputStream in){
        this.in = in;
    }

    //一次读一个字节，从缓冲区（字节数组）获取。
    public int myRead() throws IOException{
        //通过in对象读取硬盘上数据，并存储buf中。
        if (count==0){
            count=in.read(buf);
            if (count<0)
                return -1;
            pos=0;
            byte b = buf[pos];

            count--;
            pos++;
            return b&255;
        }else if (count>0){
            byte b = buf[pos];

            count--;
            pos++;
            return b&0xff;
        }
        return -1;
    }

    public void myClose() throws IOException{
        in.close();
    }
}
