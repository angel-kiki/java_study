package day09;

/**
 * Created by deng on 17/10/27.
 *
 * 内部类定义在局部时，
 * 1，不可以被成员修饰符修饰
 * 2，可以直接访问外部类中的成员，因为还持有外部类中的引用
 *      但是不可以访问它所在的类中的局部变量，只能访问被final修饰的局部变量
 */
class Outer2{
    int x = 3;

    void method(final int a){
        final int y = 4;
        class Inner{
            void function(){
                System.out.println(a);
            }
        }
        new Inner().function();
    }
}
public class InnerClassDemo2 {
    public static void main(String args[]){
        Outer2 out = new Outer2();
        out.method(7);
        out.method(8);
    }
}
