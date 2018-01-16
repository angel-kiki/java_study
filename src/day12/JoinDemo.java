package day12;

/**
 * Created by deng on 17/11/5.
 * join:
 * 当A线程执行到了B线程的join()方法时，A就会等待。等B线程都执行完，A才会执行。
 *
 * join可以用来临时加入线程执行。
 */
class Demo implements Runnable{
    @Override
    public void run() {
        for (int x=0; x<70; x++){
//            System.out.println(Thread.currentThread().getName()+"...."+x);
            System.out.println(Thread.currentThread().toString()+"...."+x);
            Thread.yield();  //临时释放执行权
        }
    }
}
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Demo d = new Demo();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);
        t1.start();
//        t1.join();

//        t1.setPriority(Thread.MIN_PRIORITY);  //设置优先级，优先级越高，抢夺资源的概率越大

        t2.start();
//        t1.join();   //放在t2后，main线程处于冻结状态，t1、t2处于活动状态，t1,t2交替执行，等到t1执行完毕后（无论t2是否执行完毕）main线程开始执行
//        t2.join();
//        t2.setPriority(Thread.MAX_PRIORITY);

//        for (int x = 0; x<80; x++){
//            System.out.println("main...."+x);
//        }
        System.out.println("over!");
    }
}
