package day10;

/**
 * Created by deng on 17/10/28.
 */
interface Inter{
    void show(int a, int b);
    void func();
}

public class Excercise {
    public static void function(Inter d){
        int a=0;
        int b=0;
        d.func();
        d.show(a,b);

    }
    public static void main(String[] args){
        //补足代码；调用两个函数，要求用匿名内部类

        function(new Inter(){
            public void show(int a, int b){
                System.out.println("show");
            }
            public void func(){
                System.out.println("func");
            }
        });

    }

}
