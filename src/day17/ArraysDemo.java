package day17;

import java.util.Arrays;
import java.util.List;

/**
 * Created by deng on 17/11/13.
 *
 * Arrays：用于操作数组的工具类。里面都是静态方法。
 * asList：将数组变成list集合
 */
public class ArraysDemo {
    public static void sop(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args) {
//        int[] nums = {2, 4, 5};
        Integer[] nums = {2, 4, 5};
//        sop(Arrays.toString(nums));
//        List<int[]> li = Arrays.asList(nums);
        List<Integer> li = Arrays.asList(nums);
        sop(li);

        /**如果数组中的元素都是对象，那么变成集合时，数组中的元素就直接转成集合中的元素。
         * 如果数组中的元素都是基本数据类型，那么会将数组作为集合中的元素存在。
         *
         */



        String[] arr = {"abc","cc","kkkk"};

        //把数组变成list集合有什么好处？
        /**可以使用集合的思想和方法来操作数组中的元素。
         * 注意：将数组变成集合，不可以使用集合的增删方法。
         * 因为数组的长度是固定。
         * 以下方法都可以使用：
         * contains
         * get
         * indexOf()
         * subList;
         * 如果做增删操作，会发生UnsupportedOperationException.
         */

        List<String> list = Arrays.asList(arr);
        sop("contains:"+list.contains("cc"));
        sop(list);
//        list.add("qq");  //UnsupportedOperationException

        //如果不用集合，需要写个方法来实现功能
//        sop(myContains(arr, "cc"));
    }

    private static boolean myContains(String[] arr, String key) {
        for (int x=0;x<arr.length;x++){
            if (arr[x].equals(key))
                return true;
        }
        return false;
    }


}
