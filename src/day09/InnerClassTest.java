package day09;

/**
 * Created by deng on 17/10/28.
 */
interface Inter{
    void method();
}

class Test{
    //通过匿名内部类补足代码。
//    static class Inner implements Inter{
//        public void method(){
//            System.out.println("method run");
//        }
//    }
//    static Inter function(){
//        return new Inner();
//    }

    static Inter function(){
        return new Inter() {
            @Override
            public void method() {
                System.out.println("method run");
            }
        };
    }

}
public class InnerClassTest {
    public static void main(String args[]){
        Test.function().method();

        show(new Inter() {
            @Override
            public void method() {
                System.out.println("method show run");
            }
        });


    }

    public static void show(Inter in){
        in.method();
    }
}

//没有继承特有的父类也可以用匿名内部类，因为所有的类都最终继承Object类
class InnerTest{
    public static void main(String args[]){
        new Object(){
            public void function(){

            }
        }.function();
    }
}
