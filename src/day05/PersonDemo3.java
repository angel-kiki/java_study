package day05;

/**
 * Created by deng on 17/10/19.
 * this关键字
 * this代表它所在函数所属对象的引用。
 * 简单说，哪个对象在调用this所在的函数，this就代表哪个对象。
 * 类中成员变量之间的调用是通过对象来完成的，而本类对象是this，所以如果没有重名函数，this可以不写
 *
 * this的应用：当定义类中功能时，该函数内部要用到调用该函数的对象时，这时用this来表示这个对象。
 * 但凡本类功能内部使用到了本类对象，都用this表示
 */
class Person3{
    private String name;
    private int age;

    {
        cry();
    }

    Person3(int age){
        this.age = age;
    }

    Person3(String name){
        this.name = name;
//        name = name;
//        System.out.println("B: name="+name+",,age="+age);
    }
    Person3(String name, int age){
//        name = name;
        this.name = name;
        this.age = age;
//        System.out.println("C: name="+name+",,age="+age);
    }

    public void cry(){
        System.out.println("cry......");

    }

//    public void setName(String name){
//        this.name = name;
//    }
//
//    public String getName(){
//        return this.name;
//    }
//
//    public void setAge(int a){
//        this.age = a;
//    }
//
//    public int getAge(){
//        return this.age;
//    }

    public void speak(){
        System.out.println("name="+this.name+",,age="+this.age);
        this.show();
    }

    public void show(){
        System.out.println(this.name);
    }

    /**
     * 需求：给人定义一个用于比较年龄是否相同的功能
     */
    public boolean compare(Person3 p){
        return this.age == p.age;

    }


}
public class PersonDemo3 {
    public static void main(String args[]){
        Person3 p1 = new Person3(20);
        Person3 p2 = new Person3(25);
        boolean b = p1.compare(p2);
        System.out.println(b);




//        day05.Person3 p = new day05.Person3();
//        p.cry();
//        day05.Person3 p2 = new day05.Person3("lisi");
//        p2.setName("libusi");
//        System.out.println(p2.getName());

//        day05.Person3 p3 = new day05.Person3("wangwu", 10);
//        p2.speak();
//        p3.speak();
    }
}

