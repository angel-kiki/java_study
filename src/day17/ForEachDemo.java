package day17;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by deng on 17/11/13.
 * 格式：
 * for(数据类型 变量名:被遍历的集合(Collection)或者数组)
 * {}
 *
 * 对集合进行遍历。
 * 只能获取集合元素，不能对集合进行操作。
 *
 * 迭代器除了遍历，还可以进行remove集合中元素的操作。
 * 如果是用ListIterator，还可以在遍历过程中对集合进行增删改查的动作。
 *
 * 传统for和高级for有什么区别呢？
 * 高级for有一个局限性，必须有被遍历的目标。
 *
 * 建议在遍历数组的时候，还是希望用传统for，因为传统for可以定义角标
 *
 */
public class ForEachDemo {
    public static void sop(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args) {
        HashMap<Integer,String> hm = new HashMap<Integer,String>();

        hm.put(1,"a");
        hm.put(2,"b");
        hm.put(3,"c");

        Set<Integer> keySet = hm.keySet();
        for (Integer i:keySet){
            sop(i+"::"+hm.get(i));
        }

//        Set<Map.Entry<Integer,String>> entrySet = hm.entrySet();
//        for (Map.Entry<Integer,String> me:entrySet)

        for (Map.Entry<Integer,String> me:hm.entrySet()){
            sop(me.getKey()+"------"+me.getValue());
        }

    }

}
