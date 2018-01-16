package day20;

import java.io.File;

/**
 * Created by deng on 17/11/23.
 * 列出指定目录下文件或文件夹，包含子目录中的内容。
 * 也就是列出指定目录下所有内容。
 *
 * 递归要注意：
 * 1，限定条件
 *
 * 2，要注意递归的次数。尽量避免内存溢出。
 *
 */
public class FileDemo3 {
    public static void main(String[] args){
        File dir = new File("/Users/deng/Documents/Poetry");
        showDir(dir,0);

//        toBin(6);

//        int n = getSum(100000);//递归次数过多会内存溢出：java.lang.StackOverflowError
//        System.out.println("n="+n);

    }

    public static void toBin(int num){
        if (num>0){
            toBin(num/2);
            System.out.println(num%2);
        }
    }

    public static int getSum(int n){
        if (n==1)
            return 1;
        return n+getSum(n-1);
    }

    public static String getLevel(int level){
        StringBuilder sb = new StringBuilder();
        sb.append("|--");
        for (int x=0; x<level; x++){
//            sb.append("|--");
            sb.insert(0,"   ");
        }
        return sb.toString();
    }

    public static void showDir(File dir,int level){
        System.out.println(getLevel(level)+dir);
        level++;

        File[] files = dir.listFiles();
        for (int x=0; x<files.length; x++){
            if (files[x].isDirectory())
                showDir(files[x],level);  //函数自己调用自己，称为递归
            else
                System.out.println(getLevel(level)+files[x]);
        }
    }
}
