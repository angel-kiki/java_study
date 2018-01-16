package javaEnhance;

/**
 * Created by deng on 18/1/6.
 *
 * overload与override的区别：重载与重写
 * 写出overload的若干个方法，java1.5中提供了可变参数
 */
public class VariableParameter {
    public static void main(String[] args){
        System.out.println(add(2,3));
    }

    public static int add(int x, int... args){
        int sum=x;
//        for (int i=0; i<args.length;i++){
//            sum+=args[i];
//        }

        //增强for循环
        for (int arg:args){
            sum += arg;
        }
        return sum;
    }
}
