package day05;

/**
 * Created by deng on 17/10/19.
 * 构造函数及构造代码块
 */
class Person2{
    private String name;
    private int age;

    /**
     * 构造代码块。
     * 作用：给对象进行初始化。
     * 对象一建立就运行，而且优先于构造函数执行
     * 和构造函数的区别：
     * 构造代码块是给所有的对象进行统一初始化，
     * 而构造函数是给对应的对象初始化
     *
     * 构造代码块中定义的是不同对象共性的初始化内容。
     */
    {
        cry();
    }

    /**
     * 构造函数：给对象进行初始化
     * 对象一建立就运行
     * 所有构造函数都被初始化后，该类就不能被创建对象
     */
    Person2(){
        System.out.println("A: name="+name+",,age="+age);
    }
    Person2(String n){
        name = n;
        System.out.println("B: name="+name+",,age="+age);
    }
    Person2(String n, int a){
        name = n;
        age = a;
        System.out.println("C: name="+name+",,age="+age);
    }

    public void cry(){
        System.out.println("cry......");

    }

    public void setName(String n){
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int a){
        this.age = a;
    }

    public int getAge(){
        return this.age;
    }


}
public class PersonDemo2 {
    public static void main(String args[]){
        Person2 p = new Person2();
        p.cry();
        Person2 p2 = new Person2("lisi");
        p2.setName("libusi");
        System.out.println(p2.getName());
        Person2 p3 = new Person2("wangwu", 10);
    }
}
