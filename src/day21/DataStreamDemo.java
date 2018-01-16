package day21;

import java.io.*;

/**
 * Created by deng on 17/11/28.
 */
public class DataStreamDemo {
    public static void main(String[] args)throws IOException{
//        writeData();
//        readData();
//        writeUTFDemo();

//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./src/day21/utf.txt"),"utf-8");
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("./src/day21/gbk.txt"),"gbk");
//
//        osw.write("你好");
//        osw.close();

        readUTFDemo();
    }

    public static void readUTFDemo()throws IOException{
        DataInputStream dis = new DataInputStream(new FileInputStream("utfdata.txt"));

        String s = dis.readUTF();

        System.out.println(s);
        dis.close();
    }

    public static void writeUTFDemo()throws IOException{
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("utfdata.txt"));

        dos.writeUTF("你好");
        dos.close();
    }

    public static void writeData() throws IOException{
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        dos.writeInt(234);
        dos.writeBoolean(true);
        dos.writeDouble(9887.543);

        dos.close();

    }

    public static void readData() throws IOException{
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

        int num = dis.readInt();
        boolean b = dis.readBoolean();
        double d = dis.readDouble();

        sop("num="+num);
        sop("b="+b);
        sop("d="+d);

        dis.close();

    }

    public static void sop(Object obj){
        System.out.println(obj);
    }
}
