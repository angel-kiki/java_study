package day10;

/**
 * Created by deng on 17/10/28.
 */
interface Test{
    void func();
}
class Excersise3 {
    public static void main(String[] args){
        //补足代码；（匿名内部类）
        new Excersise3().show(new Test() {
            @Override
            public void func() {

            }
        });

    }
    void show(Test t){
        t.func();
    }
}
