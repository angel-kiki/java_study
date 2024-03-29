package day08;

/**
 * Created by deng on 17/10/26.
 */
abstract class Student{
    public abstract void study();
    public void sleep(){
        System.out.println("躺着睡");
    }
}

class BaseStudent extends Student{
    @Override
    public void study() {
        System.out.println("base study");
    }

    @Override
    public void sleep() {
        System.out.println("坐着睡");
    }
}

class AdvStudent extends Student{
    @Override
    public void study() {
        System.out.println("adv study");
    }
}

class DoStudent{
    public void doSome(Student stu){
        stu.study();
        stu.sleep();
    }
}
public class DuotaiDemo2 {
    public static void main(String args[]){
        DoStudent ds = new DoStudent();
        ds.doSome(new BaseStudent());
        ds.doSome(new AdvStudent());


//        BaseStudent bs = new BaseStudent();
////        bs.study();
////        bs.sleep();
//        doSome(bs);
//
//        AdvStudent as = new AdvStudent();
////        as.study();
////        as.sleep();
//        doSome(as);
    }

//    public static void doSome(Student stu){
//        stu.study();
//        stu.sleep();
//    }
}
