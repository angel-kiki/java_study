package day11;

/**
 * Created by deng on 17/11/2.
 *
 * 单例设计模式。
 *
 * 饿汉式
 class Single{
     private static final Single s = new Single();
     private Single(){}
     public static Single getInstance(){
        return s;
     }
 }

 *
 * 懒汉式：
 class Single{
     private static Single s = null;
     private Single(){}
     public static Single getInstance(){
         if (s==null)
            s = new Single();
         return s;
     }
 }
 *
 */

class Single{
    private static Single s = null;
    private Single(){}
//    public static synchronized Single getInstance(){  //懒汉式每次都判断锁，比较低效。
    public static Single getInstance() {
        if (s == null) {
            synchronized (Single.class) {  //改为class锁
                if (s == null)
                    s = new Single();

            }
        }
        return s;
    }
}

public class SingleDemo {
    public static void main(String[] args){
        System.out.println("Hello World!");
    }
}
