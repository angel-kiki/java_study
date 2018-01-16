package day12;

/**
 * Created by deng on 17/11/2.
 */
class Res{
    private String name;
    private String sex;
    private boolean flag = false;

    public synchronized void set(String name, String sex){
        if (flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.name = name;
        this.sex = sex;
        this.flag = true;
        this.notify();
    }
    public synchronized void out(){
        if (!flag)
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println(name+"......"+sex);
        this.flag = false;
        this.notify();
    }
}

class Input implements Runnable{
    private Res r;
    Input(Res r){
        this.r = r;
    }

    @Override
    public void run() {
        int x = 0;
        while (true){
            if (x==0)
                r.set("Mickel","Male");
            else
                r.set("丽丽","女女女女女女");
            x = (x+1)%2;
//            synchronized (r) {
//                if (r.flag)
//                    try {
//                        r.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                if (x == 0) {
//                    r.name = "Mickel";
//                    r.sex = "Male";
//                } else {
//
//                    r.name = "丽丽";
//                    r.sex = "女女女女女女";
//                }
//                x = (x + 1) % 2;
//                r.flag = true;
//                r.notify();
//            }
        }
    }
}

class Output implements Runnable{
    private Res r;
    Output(Res r){
        this.r = r;
    }
    @Override
    public void run() {
        while (true){
            r.out();
//            synchronized (r) {
//                if (!r.flag)
//                    try {
//                        r.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                System.out.println(r.name + "...." + r.sex);
//                r.flag = false;
//                r.notify();
//            }
        }
    }
}
public class InputOutputDemo {
    public static void main(String[] args){
        Res res = new Res();

        new Thread(new Input(res)).start();
        new Thread(new Output(res)).start();

//        Input input = new Input(res);
//        Output output = new Output(res);
//
//        Thread t1 = new Thread(input);
//        Thread t2 = new Thread(output);
//        t1.start();
//        t2.start();
    }
}


//notifyAll();

/*
wait:
notify();
notifyAll();

都使用在同步中，因为要对持有监视器（锁）的线程操作。
之所以要使用在同步中，因为只有同步才具有锁。

为什么这些操作线程的方法要定义Object类中呢？
因为这些方法在操作同步中线程时，都必须要标识他们所操作线程中有的锁，
只有同一个锁上的被等待线程，可以被同一个锁上notify唤醒。
不可以对不同锁中的线程进行唤醒。

也就是说，等待和唤醒必须是同一个锁



 */