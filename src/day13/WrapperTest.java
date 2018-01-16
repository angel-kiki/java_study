package day13;

import java.util.Arrays;

/**
 * Created by deng on 17/11/12.
 *
 * 练习：对一个字符串中的数值进行从小到大的排序
 *
 * "20 78 9 -7 88 36 29"
 *
 * 思路：
 * 1、用字符串对象的切割方法将大串变成多个小串。
 * 2、数值最终变成小字符串，需要变成一个int数。字符串->基本类型可以使用包装类。
 * 3、对int数组排序
 * 4、将排序后的int数组变成字符串
 */
public class WrapperTest {
    private static final String SPACE_SEPERATOR = " ";


    public static void sop(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args){
        String numStr = "20 78 9 -7 88 36 29";
        sop("排序前："+numStr);

        numStr = sortStringNumber(numStr);
        sop("排序后："+numStr);


    }

    private static String sortStringNumber(String numStr) {
        //将字符串变成字符串数组
        String[] str_arr = numStr.split(SPACE_SEPERATOR+"+");//一个或多个空格

        //将字符串数组变成int数组
        int[] num_arr = toIntArray(str_arr);

        //对int数组进行排序
        mySortArray(num_arr);

        //将排序后的int数组变成字符串
        String temp = arrayToString(num_arr);

        return temp;
    }

    private static String arrayToString(int[] num_arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num_arr.length; i++){
            if (i!=num_arr.length-1)
                sb.append(num_arr[i]+SPACE_SEPERATOR);
            else
                sb.append(num_arr[i]);

        }
        return sb.toString();
    }

    private static void mySortArray(int[] num_arr) {
        Arrays.sort(num_arr);
    }


    private static int[] toIntArray(String[] str_arr) {
        int[] arr = new int[str_arr.length];
        for (int x = 0; x < arr.length; x++){
            arr[x] = Integer.parseInt(str_arr[x]);
        }
        return arr;
    }


}
