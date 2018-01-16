package day07;

/**
 * Created by deng on 17/10/26.
 *
 * abstract class与interface的区别：
 * 主体功能放在abstract class中，扩展功能放在interface中
 *
 */
abstract class Student1{
    abstract void study();
    void sleep(){
        System.out.println("sleep");
    }
}

interface Smoking{
    void smoke();
}

class Zhangsan extends Student1 implements Smoking{
    void study(){}
    public void smoke(){}
}

class Lisi extends Student1{
    void study(){}
}

public class InterfaceTest {
    public static void main(String args[]){
        System.out.println("Hello world!");
    }
}
