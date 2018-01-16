package day11;

/**
 * Created by deng on 17/11/1.
 *
 * 同步函数用的是哪一个锁呢？
 * 函数需要被对象调用。那么函数都有一个所属对象引用，就是this。
 * 所以同步函数使用的锁是this。
 *
 * 通过该程序进行验证。
 *
 * 使用两个线程来卖票。
 * 一个线程在同步代码块中。一个线程在同步函数中。都在执行卖票动作。
 *
 * ??运行结果再研究？？？与期望的不一致。
 *
 */
class Ticket1 implements Runnable{
    private int tick = 10000;
    boolean flag = true;
    public void run(){
        if (flag) {
            while (true) {
                synchronized (this) {
                    if (tick > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {

                        }
                        System.out.println(Thread.currentThread().getName() + "...code : " + tick--);

                    }
                }
            }
        }
        else
            while (true)
                show();
    }

    public synchronized void show(){
        if (tick > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
            System.out.println(Thread.currentThread().getName() + "...show : " + tick--);

        }
    }
}
public class ThisLockDemo {
    public static void main(String[] args){
        Ticket1 t = new Ticket1();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
        t2.start();


//        Thread t3 = new Thread(t);
//        Thread t4 = new Thread(t);
//        t3.start();
//        t4.start();
    }
}
