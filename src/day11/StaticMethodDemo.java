package day11;

/**
 * Created by deng on 17/11/2.
 *
 * 如果同步函数被静态修饰后，使用的锁是什么呢？
 * 通过验证，发现不在是this，因为静态方法中也不可以定义this。
 *
 * 静态进内存是，内存中没有本类对象，但是一定有该类对应的字节码文件对象。
 * 类名.class  该对象的类型是Class
 */
class Ticket2 implements Runnable{
    private static int tick = 1000;
    boolean flag = true;
    public void run(){
        if (flag) {
            while (true) {
                synchronized (Ticket2.class) {
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

    public static synchronized void show(){
        if (tick > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
            System.out.println(Thread.currentThread().getName() + "...show : " + tick--);

        }
    }
}
public class StaticMethodDemo {
    public static void main(String[] args){
        Ticket2 t = new Ticket2();

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

