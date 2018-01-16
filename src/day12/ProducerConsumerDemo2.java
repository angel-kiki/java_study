package day12;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by deng on 17/11/5.
 * 生产者消费者例子：改进版
 * 用lock，unlock
 * signal，signalAll
 */
public class ProducerConsumerDemo2 {
    public static void main(String[] args){
        Resource1 r = new Resource1();

        Producer1 pro = new Producer1(r);
        Consumer1 con = new Consumer1(r);

        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(con);
        Thread t4 = new Thread(con);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class Resource1{
    private String name;
    private int count=1;
    private boolean flag = false;
    private Lock lock = new ReentrantLock();

    private Condition condition_pro = lock.newCondition();
    private Condition condition_con = lock.newCondition();

    public void set(String name) throws InterruptedException{
        lock.lock();
        try {
            while (flag) {
                condition_pro.await();
            }
            this.name = name + "--" + count++;

            System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
            flag = true;
            condition_con.signal();
        }
        finally {
            lock.unlock();
        }

    }
    public void out() throws InterruptedException{
        lock.lock();
        try {
            while (!flag){
                condition_con.await();
            }
            System.out.println(Thread.currentThread().getName()+"..........消费者........."+this.name);
            flag = false;
            condition_pro.signal();
        }finally {
            lock.unlock();
        }

    }
}

class Producer1 implements Runnable{
    private Resource1 res;
    Producer1(Resource1 res){
        this.res = res;
    }

    @Override
    public void run() {
        while (true){
            try {
                res.set("+商品+");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Consumer1 implements Runnable{
    private Resource1 res;
    Consumer1(Resource1 res){
        this.res = res;
    }

    @Override
    public void run() {
        while (true){
            try {
                res.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}