package day20;

import java.io.File;

/**
 * Created by deng on 17/11/23.
 *
 * 删除原理：
 * 在windows中，删除目录是从里面往外删除的。
 * 既然是从里往外删除，就需要用到递归。
 */
public class RemoveDir {
    public static void main(String[] args){
        File dir = new File("/Users/deng/Documents/TestHtml/test");
        removeDir(dir);
    }

    public static void removeDir(File dir){
        File[] files = dir.listFiles();

        for (int x=0; x<files.length; x++){
            if (!files[x].isHidden()&&files[x].isDirectory())
                removeDir(files[x]);
            else
                System.out.println(files[x].toString()+":-file-:"+files[x].delete());
        }
        System.out.println(dir+"::dir::"+dir.delete());
    }
}
