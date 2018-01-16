package day06;

/**
 * Created by deng on 17/10/24.
 */
class Person1{
    private String name;
    private int age;
    static String country = "cn";
    {
        System.out.println(name+"..."+age);
    }

    static {
        System.out.println("###########");
    }

    Person1(String name, int age){
        System.out.println(name+"..."+age+"..."+country);
    }

    public static void showCountry(){
        System.out.println("country = "+country);
    }

}
class PersonDemo {
    public static void main(String args[]){
        Person1 p = new Person1("xiaoma",20);
        Person1 p2 = new Person1("xiaoma1",200);
    }
}

/**
 *  Person1 p = new Person1("xiaoma",20);
 *  做的事情及步骤：
 *  1、因为new用到了Person1.class，所以会先找到Person1.class文件并加载到内存中。
 *  2、执行该类的静态代码块，如果有的话，给Person1.class类进行初始化，且只执行一次
 *  3、在堆内存中开辟空间，分配内存地址
 *  4、在堆内存中建立对象的特有属性，并进行默认初始化
 *  5、对属性进行显示初始化
 *  6、对对象进行构造代码块初始化
 *  7、对对象进行对应的构造函数初始化
 *  8、将内存地址赋给栈内存中的p变量
 */
