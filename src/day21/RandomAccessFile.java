package day21;


import java.io.IOException;
import java.io.*;

/**
 * Created by deng on 17/11/28.
 *
 * RandomAccessFile
 * 该类不算是IO体系中子类，而是直接继承自Object。
 *
 * 但是它是IO包中成员，因为它具备读和写功能。
 * 内部封装了一个数组，而且通过指针数组的元素进行操作。
 * 可以通过getFilePointer获取指针位置，同时可以通过seek改变指针的位置。
 *
 * 其实完成读写的原理就是内部封装了字节输入流和输出流。
 *
 * 通过构造函数可以看出，该类智能操作文件，而且操作文件还有模式：只读r,,读写rw等
 *
 * 如果模式为只读r。不会创建文件，会去读取一个已存在文件，如果该文件不存在，则会出现异常。
 * 如果模式为rw。那么要操作的文件不存在，会自动创建，如果存在则不会覆盖
 */
public class RandomAccessFile {


    public static void main(String[] args){

    }

//    public static void writeFile()throws IOException{
//        RandomAccessFile raf = new RandomAccessFile("ran.txt","rw");
//
//        raf.write();
//    }
}
