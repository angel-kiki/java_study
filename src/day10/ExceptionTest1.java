package day10;

/**
 * Created by deng on 17/10/28.
 * 练习：
 * 有一个圆形和长方形。
 * 都可以获取面积。对于面积如果出现非法的数值，视为是获取面积出现问题。
 * 问题通过异常来表示。
 * 现有对这个程序进行基本设计。
 */
class NoValueException extends RuntimeException{
    NoValueException(String message){
        super(message);
    }
}
interface Shape{
    void getArea();
}

class Rec implements Shape{
    private int len, wid;

    Rec(int len, int wid) //throws NoValueException
    {

        if (len<=0 || wid<=0){
            throw new NoValueException("长宽输入非法！");
        }
        this.len = len;
        this.wid = wid;

    }

    public void getArea(){
        System.out.println("长方形的面积为："+len*wid);
    }
}

class Circle implements Shape{
    private int radius;
    public static final double PI = 3.14;

    Circle(int radius) //throws NoValueException
    {
        if (radius<=0){
            throw new NoValueException("半径输入非法！");
        }
        this.radius = radius;

    }

    public void getArea(){
        System.out.println("圆形的面积为："+PI*radius*radius);
    }
}

public class ExceptionTest1 {
    public static void main(String [] args){
//        try {
//            Rec rec = new Rec(5,3);
//            rec.getArea();
//        }catch (NoValueException e){
//            System.out.println(e.toString());
//        }
//
//        try {
//            Circle circle = new Circle(0);
//            circle.getArea();
//        }catch (NoValueException e){
//            System.out.println(e.toString());
//        }

        Rec rec = new Rec(5,3);
        rec.getArea();

        Circle circle = new Circle(0);
        circle.getArea();

        System.out.println("over");



    }
}
