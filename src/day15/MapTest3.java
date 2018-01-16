package day15;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by deng on 17/11/11.
 *
 * 练习：
 * "sdfgz+xcvas-dfxcvd-f"获取该字符串中的字母出现的次数。
 *
 * 希望打印结果：a(1)c(2).....
 *
 * 通过结果发现，每一个字母都有对应的次数。
 * 说明字母和次数之间都有映射关系。
 *
 * 注意，当发现有映射关系时，可以选择Map集合。因为Map集合中存放的就是映射关系。
 *
 * 什么时候使用Map集合呢？
 * 当数据之间存在着映射关系时，就要先想Map集合。
 *
 * 思路：
 * 1，将字符串转换成字符串组。因为要对每一个字母进行操作。
 * 2，定义一个Map集合，因为打印结果的字母有顺序，所以使用treemap集合。
 * 3，遍历字符数组。
 *    将每一个字母作为键去查map集合。
 *    如果返回null，将该怎么和1存入到Map集合中。
 *    如果返回不是null，说明该字母在Map集合已经存在并有对应次数。
 *    那么就获取该次数并进行自增，然后将该字母和自增后的次数存入到Map集合中。覆盖原来键所对应的值。
 * 4，将Map集合中的数据变成指定的字符串形式返回。
 */
public class MapTest3 {
    public static void sop(Object obj){
        System.out.println(obj);
    }

    public static String charCount(String str){
        char[] chs = str.toCharArray();

        TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();

        int count = 0;
        for (int x=0; x<chs.length;x++){
            if (!(chs[x]>='a'&&chs[x]<='z'||chs[x]>='A'&&chs[x]<='Z'))
                continue;
            Integer value = tm.get(chs[x]);

            if (value==null)
                count = 1;
            count++;
            tm.put(chs[x],count);
            count = 0;

//            if (value==null)
//                tm.put(chs[x],1);
//            else {
//                value = value+1;
//                tm.put(chs[x],value);
//            }

        }

        StringBuilder sb = new StringBuilder();

        Set<Map.Entry<Character,Integer>> entrySet = tm.entrySet();
        Iterator<Map.Entry<Character,Integer>> it = entrySet.iterator();

        while (it.hasNext()){
            Map.Entry<Character,Integer> me = it.next();

            Character ch = me.getKey();
            Integer value = me.getValue();
            sb.append(ch+"("+value+")");
        }



        return sb.toString();
    }


    public static void main(String[] args){
        StringBuilder str = new StringBuilder();
        str.append("sdfgz+xcvas-dfxcvd-f");
        sop(charCount(str.toString()));

    }
}
