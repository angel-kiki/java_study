package day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by deng on 17/11/10.
 * 练习：按照字符串长度排序
 *
 * 字符串本身具备比较性。但是它的比较方式不是所需要的，这时候就需要使用比较器
 */
public class TreeSetTest {
    public static void main(String[] args){
//        TreeSet ts = new TreeSet(); //自然排序
        TreeSet ts = new TreeSet(new StrLenComparator()); //自定义排序

        ts.add("abcd");
        ts.add("cc");
        ts.add("cba");
        ts.add("aaaa");
        ts.add("z");
        ts.add("hahaha");

        Iterator it = ts.iterator();

        while (it.hasNext())
            System.out.println(it.next());
    }
}

class StrLenComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;

//        if (s1.length()>s2.length())
//            return 1;
//        if (s1.length()==s2.length())
//            return -1;
//        return 0;

        int num = new Integer(s1.length()).compareTo(new Integer(s2.length()));
        if (num==0)
            return s1.compareTo(s2);
        return num;
    }
}