package day10;

/**
 * Created by deng on 17/10/28.
 * 补足compare函数内的代码，不许添加其他函数。
 */
class Circle1{
    private static double pi=3.14;
    private double radius;
    public Circle1(double r){
        radius = r;
    }
    public static double compare(Circle1[] cir){
        //程序代码//其实就是在求数组中的最大值
        int max = 0;//double max = cir[0].radius;
        for (int x = 1;x<cir.length;x++){
            if (cir[x].radius>cir[max].radius){
                max = x;
            }
        }
        return cir[max].radius;
    }
}
public class Excersese4 {
    public static void main(String[] args){
        Circle1 cir[] = new Circle1[3];//创建了一个类类型数组
        cir[0] = new Circle1(1.0);
        cir[1] = new Circle1(2.0);
        cir[2] = new Circle1(4.0);
        System.out.println("最大的半径值是："+Circle1.compare(cir));
    }
}
