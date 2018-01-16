package day06;

/**
 * Created by deng on 17/10/25.
 *
 * 饿汉式：先初始化对象。
 * Single类一进内存就创建对象
 class Single{
     private Single(){}

     private static Single s = new Single();

     public static Single getInstance(){
     return s;
     }
 }

 * 懒汉式：对象是方法被调用时才初始化，也叫对象的延时加载
 * Single2类进内存，对象还没有存在，只要调用了getInstance方法时才建立对象。
 class Single2{
     private static Single2 s = null;
     private Single2(){}
     public static Single2 getInstance(){
     if(s==null)
     s = new Single2();
     return s
     }
 }
 *
 * 记录原则：定义单例，建议使用饿汉式
 */
class Single2{
    private static Single2 s = null;
    private Single2(){}
//    //synchronized 加锁
//    public static synchronized Single2 getInstance(){
//        if(s==null)
//            s = new Single2();
//        return s;
//    }

    //双重判定减少读锁提高效率，可以解决问题，但比饿汉式代码多
    public static  Single2 getInstance(){
        if(s==null) {
            synchronized (Single2.class) {
                if (s == null)
                    s = new Single2();
            }
        }
        return s;
    }
}
public class SingleDemo2 {
    public static void main(String args[]){

    }
}
