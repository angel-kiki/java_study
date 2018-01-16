package day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by deng on 17/11/10.
 * 当元素自身不具备比较性时，或者具备的比较性不是所需要的。这时就需要让集合自身具备比较性。
 * 定义了比较强，将比较强对象作为参数传递给TreeSet集合的构造函数。
 *
 * 当两种排序都存在时，以比较器为主。
 *
 * 定义一个类，实现Comparator接口，覆盖compare方法。
 */
public class TreeSetDemo2 {
    public static void sop(Object obj){
        System.out.println(obj);
    }
    public static void main(String[] args){
//        TreeSet ts = new TreeSet();
        TreeSet ts = new TreeSet(new MyCompare());

        ts.add(new Student("lisi02",22));
        ts.add(new Student("lisi007",20));
        ts.add(new Student("lisi007",21));
        ts.add(new Student("lisi09",19));
        ts.add(new Student("lisi08",19));
        ts.add(new Student("lisi01",40));
//        Student st = new Student("zhangsan",20);
//        sop(st);
//        ts.add(st);


        Iterator it = ts.iterator();
        while (it.hasNext()){
            Student stu = (Student)it.next();
            System.out.println(stu.getName()+"..."+stu.getAge());
        }
    }
}

class MyCompare implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;

        int num = s1.getName().compareTo(s2.getName());

        if (num==0)
//            return s1.getAge()-s2.getAge();
            return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
        return num;
    }
}
