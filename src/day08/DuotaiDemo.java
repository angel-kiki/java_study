package day08;

/**
 * Created by deng on 17/10/26.
 *
 * 1，多态的体现
 *      父类的引用指向了自己的子类对象。
 *      父类的引用也可以接收自己的子类对象。
 *
 * 2，多态的前提
 *      必须的类与类之间有关系，要么继承，要么实现。
 *
 * 3，多态的好处
 *      多态的出现大大的提高了程序的扩展性。
 *      通常还有一个前提，就是存在覆盖
 *
 * 4，多态的弊端：
 *      提高了扩展性，但是只能使用父类的引用访问父类的成员
 *
 * 5，多态的应用
 */
abstract class Animal{
    abstract void eat();
}

class Cat extends Animal{
    @Override
    void eat() {
        System.out.println("吃鱼");
    }
    void catchMouse(){
        System.out.println("抓老鼠");
    }
}
class Dog extends Animal{
    @Override
    void eat() {
        System.out.println("肯骨头");
    }
    void kanjia(){
        System.out.println("看家");
    }
}
public class DuotaiDemo {
    public static void main(String args[]){
        Animal a = new Cat();//类型提升。向上转型
        a.eat();

        //如果想要调用猫的特有方法时，如何操作？
        //强制将父类的引用，转成子类类型，向下转型
        Cat c = (Cat)a;
        c.catchMouse();

        //千万不要出现这样的操作，就是将父类对象转成子类类型。
        //我们能转换的是父类引用指向了自己的子类对象时，该应用可以被提升，也可以被强制转换。
        //多态自始至终都是子类对象在做着变化
//        Animal a = new Animal();
//        Cat c = (Cat) a;

        function(new Cat());
        function(new Dog());
    }

    public static void function(Animal a){
        a.eat();

        if (a instanceof Cat){
            Cat c = (Cat) a;
            c.catchMouse();
        }else if (a instanceof Dog){
            Dog c = (Dog) a;
            c.kanjia();
        }
    }
}
