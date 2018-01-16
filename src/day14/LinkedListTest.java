package day14;

import java.util.LinkedList;

/**
 * Created by deng on 17/11/7.
 * 使用LinkedList模拟一个堆栈或者队列数据结构。
 *
 * 堆栈：先进后出 如同一个杯子
 * 队列：先进先出 FIFO：First in first out 如同一个水管
 */
class Duilie{
    private LinkedList link;

    Duilie(){
        link = new LinkedList();
    }

    public void myAdd(Object obj){
        link.addFirst(obj);
    }

    public Object myGet(){
        return link.removeLast();
    }

    public Object myGet2(){
        return link.removeFirst();
    }

    public boolean isNull(){
        return link.isEmpty();
    }
}

public class LinkedListTest {
    public static void sop(Object obj){
        System.out.println(obj);
    }
    public static void main(String[] args){
        Duilie d1 = new Duilie();
        d1.myAdd("java01");
        d1.myAdd("java02");
        d1.myAdd("java03");
        d1.myAdd("java04");

//        while (!d1.isNull()) {
//            sop(d1.myGet());
//        }
        while (!d1.isNull()) {
            sop(d1.myGet2());
        }

    }
}
