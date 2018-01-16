package day06;

/**
 * Created by deng on 17/10/24.
 * 单例设计模式：解决一个类在内存只存在一个对象。
 *
 * 想要保证对象唯一。
 * 1，为了避免其他程序过多建立该对象，先禁止其他程序建立该对象
 * 2，还为了让其他程序可以访问到该对象，只好在本类中，自定义一个对象
 * 3，为了方便其他程序对自定义对象的访问，可以对外提供一些访问方式
 *
 * 这三步怎么用代码体现呢？
 * 1，将构造函数私有化
 * 2，在类中创建一个本类对象
 * 3，提供一个方法可以获取到该对象
 *
 * 对于类，该怎么描述还怎么描述，在需要保证对象唯一时，只要加上这三步就可以
 */
class Single{
    private Single(){}

    private static Single s = new Single();

    public static Single getInstance(){
        return s;
    }

}

class SingleDemo {
    public static void main(String args[]){
        Single ss = Single.getInstance();
    }
}

class Student{
    private int age;

    /*加上以下三步即可*/
    private static Student s = new Student();
    private Student(){}
    public static Student getStudent(){
        return s;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}