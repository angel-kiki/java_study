package day17;

import java.util.Arrays;
import static java.util.Arrays.*;//导入的是Arrays这个类中的所有静态成员

/**
 * Created by deng on 17/11/13.
 *
 * StaticImport 静态导入。
 *
 * 当类名重名时，需要指定具体的包名。
 * 当方法重名时，指定具备所属的对象或者类。
 */
public class StaticImport {
    public static void sop(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5};

//        Arrays.sort(arr);
        sort(arr);
//        int index = Arrays.binarySearch(arr,1);
        int index = binarySearch(arr,1);
//        sop(Arrays.toString(arr));
//        sop(toString(arr));  //默认继承Object，使用的是Object类中的toString方法，不能加参数。所以报错
                                //方法重名时，需要指明方法所属的类。
        sop("index="+index);

    }
}