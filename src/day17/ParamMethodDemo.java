package day17;

/**
 * Created by deng on 17/11/13.
 *
 * JDK1.5版本出现的新特性。
 *
 * 方法的可变参数在使用时一定要注意：可变参数一定要定义在参数列表的最后面。
 */
public class ParamMethodDemo {
    public static void main(String[] args) {
//        show(2,3);
//        show(2,3, 4);

//        int[] arr1 = {2,3,4};
//        show(arr1);
//
//        int[] arr2 = {2,3};
//        show(arr2);

        /*
         可变参数：其实就是上一种数组参数的简写形式。
         不用每一次都手动的建立数组对象，只要将要操作的元素作为参数传递即可。
         隐式将这些参数封装成了数组。
         */
        show("abc",2,3);
        show("a",2,3,4,5);
        show("a");
    }

    public static void show(String s,int... arr){
        System.out.println(s+arr.length);
    }
    /*
    private static void show(int[] arr){
        System.out.println(arr);
    }
    */
    /*
    private static void show(int a, int b) {
        System.out.println(a+","+b);
    }

    private static void show(int a, int b, int c) {
        System.out.println(a+","+b+","+c);
    }
    */
}
