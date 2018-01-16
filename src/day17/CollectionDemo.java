package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by deng on 17/11/12.
 */
public class CollectionDemo {

    public static void sop(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args){
//        sortDemo();
//        maxDemo();
        binarySeachDemo();
    }

    private static void binarySeachDemo() {
        List<String> list = new ArrayList<String>();

        list.add("abcd");
        list.add("aaa");
        list.add("zz");
        list.add("kkkkk");
        list.add("qq");
        list.add("z");

        sop(list);

//        Collections.sort(list);
//        sop(list);
//
//        int index = Collections.binarySearch(list,"aaaa");
//        int index = halfSearch(list,"cc");
//        sop("index="+index);

        Collections.sort(list,new StrLenComparator());
        sop(list);
        int index = halfSearch2(list,"aa",new StrLenComparator());
        sop("index="+index);

    }

    private static int halfSearch(List<String> list, String key) {
        int max, min, mid;
        max = list.size()-1;
        min = 0;

        while (min<max){
            mid = (max+min)>>1;

            String str = list.get(mid);

            int num = str.compareTo(key);
            if (num>0)
                max = mid - 1;
            else if (num<0)
                min = mid + 1;
            else
                return mid;
        }
        return -min-1;

    }

    private static int halfSearch2(List<String> list, String key, Comparator<String> cmp) {
        int max, min, mid;
        max = list.size()-1;
        min = 0;

        while (min<max){
            mid = (max+min)>>1;

            String str = list.get(mid);

            int num = cmp.compare(str,key);
            if (num>0)
                max = mid - 1;
            else if (num<0)
                min = mid + 1;
            else
                return mid;
        }
        return -min-1;

    }

    private static void maxDemo() {
        List<String> list = new ArrayList<String>();

        list.add("abcd");
        list.add("aaa");
        list.add("zz");
        list.add("kkkkk");
        list.add("qq");
        list.add("z");

        sop(list);

        Collections.sort(list);
        sop(list);

//        String max = Collections.max(list);
        String max = Collections.max(list,new StrLenComparator());
        sop("max="+max);
    }

    private static void sortDemo() {
        List<String> list = new ArrayList<String>();

        list.add("abcd");
        list.add("aaa");
        list.add("zz");
        list.add("kkkkk");
        list.add("qq");
        list.add("z");

        sop(list);

//        Collections.sort(list);
        Collections.sort(list,new StrLenComparator());
        sop(list);
    }

}

class StrLenComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        if (o1.length()>o2.length())
            return 1;
        if (o1.length()<o2.length())
            return -1;
        return o1.compareTo(o2);
    }
}



