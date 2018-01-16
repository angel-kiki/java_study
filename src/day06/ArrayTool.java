package day06;

/**
 * Created by deng on 17/10/20.
 * 静态的应用：
 * 每一个应用程序中都有共性的功能，可以将这些功能进行抽取，独立封装，以便复用。
 */

public class ArrayTool {
    public static int getMax(int[] arr){
        int max = 0;
        for (int x=1;x<arr.length;x++){
            if (arr[x]>arr[max]){
                max = x;
            }
        }
    return arr[max];
    }
}


//class Demo{
//    public static void main(String args[]){
//        int[] arr = {3,4,1,8};
//        int max = getMax(arr);
//        System.out.println("max = "+max);
//
//    }
//
//    public static int getMax(int[] arr){
//        int max = 0;
//        for (int x=1;x<arr.length;x++){
//            if (arr[x]>arr[max]){
//                max = x;
//            }
//        }
//        return arr[max];
//    }
//}
//
//
//class Test{
//    public static int getMax(int[] arr){
//        int max = 0;
//        for (int x=1;x<arr.length;x++){
//            if (arr[x]>arr[max]){
//                max = x;
//            }
//        }
//        return arr[max];
//    }
//}