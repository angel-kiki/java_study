package day11;

/**
 * Created by deng on 17/11/2.
 * 死锁
 */
class Ticket3 implements Runnable{
    private int tick = 1000;
    boolean flag = true;
    Object obj = new Object();
    public void run(){
        if (flag) {
            while (true) {
                synchronized (obj) {
                    show();
                }
            }
        }
        else
            while (true)
                show();
    }

    public synchronized void show(){
        synchronized (obj) {
            if (tick > 0) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {

                }
                System.out.println(Thread.currentThread().getName() + "...show : " + tick--);

            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args){
        Ticket3 t = new Ticket3();

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