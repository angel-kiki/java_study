package day10;

/**
 * Created by deng on 17/10/28.
 */
class Super{
    int i = 0;
    public Super(){
        System.out.println("B");
        i+=2;
    }
}

public class Demo1 extends Super {
    public Demo1(String a){
        System.out.println("C");
        i=5;
    }
    public static void main(String[] args){
        int i=4;
        Super d = new Demo1("A");
        System.out.println(d.i);
    }
}
