package day12;

/**
 * Created by deng on 17/11/5.
 * 多线程的写法
 */
public class ThreadTest {
    public static void main(String[] args){
        //线程一：匿名内部类
        new Thread(){
            @Override
            public void run() {
                for (int x=0; x<100; x++){
                    System.out.println(Thread.currentThread().getName()+"..."+x);
                }
            }
        }.start();


        //线程二：main方法中直接写
        for (int x=0; x<100; x++){
            System.out.println(Thread.currentThread().getName()+"..."+x);
        }

        //线程三：实现接口
        Runnable r = new Runnable(){
            @Override
            public void run() {
                for (int x=0; x<100; x++){
                    System.out.println(Thread.currentThread().getName()+"..."+x);
                }
            }
        };
        new Thread(r).start();

        //线程四：外部类
        new Test1().start();
    }
}

class Test1 extends Thread{
    @Override
    public void run() {
        for (int x=0; x<100; x++){
            System.out.println(Thread.currentThread().getName()+"..."+x);
        }
    }
}
