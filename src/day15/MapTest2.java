package day15;

import java.util.*;

/**
 * Created by deng on 17/11/11.
 *
 * 需求：对学生对象的年龄进行升序排序。
 *
 * 因为数据是以键值对的形式存在的。
 * 所以要使用可以排序的Map集合。TreeMap。
 */
class StuComp implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        int num = o1.getName().compareTo(o2.getName());

        if (num==0)
            return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));

        return num;
    }
}

public class MapTest2 {
    public static void sop(Object obj){
        System.out.println(obj);
    }

    public static void main(String[] args){
        TreeMap<Student,String> tm = new TreeMap<Student,String>(new StuComp());

        tm.put(new Student("aisi2",22),"beijing");
        tm.put(new Student("lisi2",21),"shanghai");
        tm.put(new Student("bisi3",25),"nanjing");
        tm.put(new Student("lisi4",25),"nanjing");
        tm.put(new Student("lisi4",24),"wuhan");

        Set<Map.Entry<Student,String>> entrySet = tm.entrySet();

        Iterator<Map.Entry<Student,String>> it = entrySet.iterator();

        while (it.hasNext()){
            Map.Entry<Student,String> me = it.next();

            Student stu = me.getKey();
            String addr = me.getValue();

            sop(stu+":"+addr);

        }
    }
}
