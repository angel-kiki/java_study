package day15;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by deng on 17/11/9.
 *
 * Set:无序，不可以重复。
 *     |--HashSet：数据结构是哈希表。线程是非同步的。
 *                 保证元素唯一性的原理：判断元素的hashCode值是否相同。
 *                 如果相同，还会继续判断元素的equals方法，是否为true。
 *     |--TreeSet：可以对Set集合中的元素进行排序。
 *                 底层数据结构是二叉树。
 *                 保证元素唯一性的依据：compareTo方法return 0.
 *
 *                 TreeSet排序的第一种方式：让元素自身具备比较性。元素需要实现comparable接口，复写compareTo方法
 *                 这种方式也称为元素的自然顺序，也叫默认顺序。
 *
 *                 TreeSet的第二种排序方式：当元素自身不具备比较性时，或者具备的比较性不是所需要的。这时就需要让集合自身具备比较性。
 *                 在集合初始化时就有了排序方式。
 *
 *
 *
 * 需求：
 * 往TreeSet集合中存储自定义对象学生。
 * 想安装学生的年龄进行排序。
 *
 * 记住：排序时，当主要条件相同时，一定判断一下次要条件
 */
public class TreeSetDemo {
    public static void sop(Object obj){
        System.out.println(obj);
    }
    public static void main(String[] args){
        TreeSet ts = new TreeSet();

        ts.add(new Student("lisi02",22));
        ts.add(new Student("lisi007",20));
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

//class Student implements Comparable  //该接口强制让学生具备比较性
//{
//    private String name;
//    private int age;
//
//    Student(String name, int age){
//        this.name = name;
//        this.age = age;
//    }
//
//    public int compareTo(Object obj){
//
////        return 1;  //顺序
//
////        return -1; //倒序
//
////        return 0; //只存一个
//
//        if (!(obj instanceof Student))
//            throw new RuntimeException("不是学生对象");
//        Student s = (Student)obj;
//
//        if (this.age>s.age)
//            return 1;
//        if (this.age==s.age)
//            return this.name.compareTo(s.name);
//        return -1;
//    }
//
//    public String getName(){
//        return name;
//    }
//
//    public int getAge(){
//        return age;
//    }
//}
