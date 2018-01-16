package day20;

import java.io.File;
import java.io.IOException;

/**
 * Created by deng on 17/11/22.
 *
 * File类常见方法：
 * 1，创建。
 *    boolean createNewFile()：在指定位置创建文件，如果该文件已经存在，则不创建，返回false
 *                             和输出流不一样，输出流对象一建立就创建文件，而且文件已经存在时会覆盖。
 *
 * 2，删除。
 *    boolean delete(); 删除失败返回false。
 *    void deleteOnExit(); 在程序退出时删除指定文件。
 *
 * 3，判断。
 *
 * 4，获取信息。
 *
 */
public class FileDemo {
    public static void main(String[] args) throws IOException{
//        consMethod();

        method_1();
    }

    public static void method_1() throws IOException{
        File f = new File("file.txt");

        f.deleteOnExit();//即使发生了异常也能够在程序退出时删除文件

//        sop("create:"+f.createNewFile());

        sop("delete:"+f.delete());
    }




    //创建File对象
    public static void consMethod(){
        //将a.txt封装成File对象。可以将已有的和未出现的文件或者文件夹封装成对象。
        File f1 = new File("a.txt");

        //
        File f2 = new File("/Users/deng/Desktop","b.txt");


        File d = new File("/Users/deng/Desktop");
        File f3 = new File(d,"c.txt");

        sop("f1:"+f1);
        sop("f2:"+f2);
        sop("f3:"+f3);

        File f4 = new File(File.separator+"Users"+File.separator+"deng"+File.separator+"Desktop"+File.separator+"d.txt");
        sop("f4:"+f4);
    }

    public static void sop(Object obj){
        System.out.println(obj);
    }
}
