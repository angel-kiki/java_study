package day10;

/**
 * Created by deng on 17/10/28.
 */
public class Excersise2 {
    public static void func(){
        try {
            throw new Exception();
//            System.out.println("A");//无法访问的语句
        }catch (Exception e){
            System.out.println("B");
        }
    }
    public static void main(String[] args){
        try {
            func();
        }catch (Exception e){
            System.out.println("C");
        }
        System.out.println("D");
    }
}
