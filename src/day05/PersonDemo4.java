package day05;

/**
 * Created by deng on 17/10/19.
 * this语句：用于构造函数间互相调用
 * this语句只能放在构造函数的第一行。因为初始化要先执行。
 */
class Person4{
    private String name;
    private int age;

    Person4(){
//        this("haha"); //不允许存在，相当于死循环

    }

    Person4(String name){
        this();
//        this.name = name;
        this.name = "hahaha";
    }

    Person4(String name, int age){
        this(name);
        this.name = name;
        this.age = age;
    }

}
public class PersonDemo4 {
    public static void main(String args[]){
        Person4 p = new Person4("lisi", 30);
        Person4 p1 = new Person4("lisi2", 36);
    }
}
