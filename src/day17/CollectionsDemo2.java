package day17;

import java.util.*;

/**
 * Created by deng on 17/11/12.
 */
class StrComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}

public class CollectionsDemo2 {
    public static void sop(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args) {
//        fillDemo();

//        replaceAllDemo();

//        orderDemo();

        shuffleDemo();
    }

    private static void shuffleDemo() {
        List<String> list = new ArrayList<String>();

        list.add("abcd");
        list.add("aaa");
        list.add("zz");
        list.add("kkkkk");

        sop(list);
        Collections.shuffle(list);
        sop(list);
    }

    private static void orderDemo() {
        //按自然顺序排序
//        TreeSet<String> ts = new TreeSet<String>();
        //按自然顺序倒序排列，自己写比较器
//        TreeSet<String> ts = new TreeSet<String>(new StrComparator());
        //按自然顺序倒序排列，用现成的方法，推荐，有现成方法的绝对不要重新写，麻烦！
//        TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());
        //按长度排序
//        TreeSet<String> ts = new TreeSet<String>(new StrLenComparator());
        //按长度倒序排列
        TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new StrLenComparator()));

        ts.add("abcde");
        ts.add("aaa");
        ts.add("kk");
        ts.add("c");

        Iterator it = ts.iterator();
        while (it.hasNext()){
            sop(it.next());
        }

    }

    private static void replaceAllDemo() {
        List<String> list = new ArrayList<String>();

        list.add("abcd");
        list.add("aaa");
        list.add("zz");
        list.add("kkkkk");

        sop(list);

        Collections.replaceAll(list,"aaa","pp");

        sop(list);

        //反转
        Collections.reverse(list);
        sop(list);

    }

    /**
    *  练习：fill方法可以将list集合中所有元素替换成指定元素。
     *  将list集合中部分元素替换成指定元素。课下完成？？
    */
    private static void fillDemo() {
        List<String> list = new ArrayList<String>();

        list.add("abcd");
        list.add("aaa");
        list.add("zz");
        list.add("kkkkk");

        sop(list);
        Collections.fill(list,"pp");
        sop(list);
    }

}
