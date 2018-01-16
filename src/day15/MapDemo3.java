package day15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by deng on 17/11/12.
 *
 * map扩展知识。
 *
 * Map集合被使用是因为具备映射关系。
 *
 * 学校
 *    |--班级A
 *        |--学号01，姓名"张三"
 *        |--学号02，姓名"李四"
 *    |--班级
 *        |--学号01，姓名"王五"
 *        |--学号02，姓名"赵六"
 *
 * Student类需要写
 *
 */
public class MapDemo3 {
    public static void sop(Object obj){
        System.out.println(obj);
    }

    public static void demo(){
        HashMap<String,List<Student>> czbk = new HashMap<String,List<Student>>();

        List<Student> yure = new ArrayList<Student>();
        List<Student> jiuye = new ArrayList<Student>();

        czbk.put("yureban",yure);
        czbk.put("jiuyeban",jiuye);

        yure.add(new Student("zhangsan",20));
        yure.add(new Student("lisi",21));
        jiuye.add(new Student("wangwu",23));
        jiuye.add(new Student("zhaoliu",24));

        Iterator<String> it = czbk.keySet().iterator();

        while (it.hasNext()){
            String roomName = it.next();
            List<Student> room = czbk.get(roomName);

            sop(roomName);
            getInfos(room);
        }
    }

    public static void getInfos(List<Student> list){
        Iterator<Student> it = list.iterator();
        while (it.hasNext()){
            Student s = it.next();
            sop(s);
        }
    }

    public static void main(String[] args){
        HashMap<String,HashMap<String,String>> czbk = new HashMap<String,HashMap<String, String>>();
        HashMap<String,String> yure = new HashMap<String, String>();
        HashMap<String,String> jiuye = new HashMap<String,String>();

        czbk.put("yureban",yure);
        czbk.put("jiuyeban",jiuye);

        yure.put("01","zhangsan");
        yure.put("02","lisi");

        jiuye.put("01","wangwu");
        jiuye.put("02","zhaoliu");

        //遍历czbk集合。获取所有的班级
        Iterator<String> it = czbk.keySet().iterator();

        while (it.hasNext()){
            String roomName = it.next();
            HashMap<String,String> room = czbk.get(roomName);

            sop(roomName);
            getStudentInfo(room);
        }



    }

    public static void getStudentInfo(HashMap<String,String> roomMap){
        Iterator<String> it = roomMap.keySet().iterator();

        while (it.hasNext()){
            String id = it.next();
            String name = roomMap.get(id);
            sop(id+":"+name);
        }
    }

}
