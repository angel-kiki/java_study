package day15;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by deng on 17/11/11.
 * Map集合：该集合存储键值对。一对一对往里存。而且要保证键的唯一性。
 *      1，添加。
 *          put(K key, V value)
 *          putAll(Map<? extends K,? extends V>m)
 *      2，删除
 *          clear()
 *          remove(Object key)
 *      3，判断。
 *          containsValue(Object value)
 *          containsKey(Object key)
 *          isEmpty()
 *      4，获取。
 *          get(Object key)
 *          size()
 *          values()
 *
 *          entrySet()
 *          keySet()
 *
 * Map
 *      |--Hashtable：底层是哈希表数据结构，不可以存入null键null值。该集合是线程同步的。jdk1.0.效率低。
 *      |--HashMap：底层是哈希表数据结构，允许使用null键null值，该集合是不同步的。jdk1.2.效率高
 *      |--TreeMap：底层是二叉树数据结构。线程不同步。可以用于给map集合中的键进行排序。
 *
 * 和Set很像。其实Set底层就是使用了Map集合。
 */
public class MapDemo {
    public static void sop(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args){
        Map<String,String> map = new HashMap<String,String>();

        //添加元素。如果出现添加时相同的键，那么后添加的值会覆盖原有键的对应值。
        //并且put方法会返回被覆盖的值。
        sop(map.put("01","zhangsan1"));
        sop(map.put("01","lisi1"));
        map.put("02","zhangsan2");
        map.put("03","zhangsan3");

        sop("containsKey:"+map.containsKey("02"));
        sop("containsKey:"+map.containsKey("022"));
//        sop("remove:"+map.remove("02"));

        sop("get:"+map.get("02"));
        sop("get:"+map.get("023"));

        map.put("04",null);  //虽然可以存进去，但是不多见
//        sop("get:"+map.get("04"));
        //可以通过get方法的返回值来判断一个键是否存在。通过返回null来判断。

        //获取map集合中所有的值。
        Collection<String> coll = map.values();

        sop(coll);


        sop(map);

    }
}
