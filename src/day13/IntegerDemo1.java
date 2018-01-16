package day13;

/**
 * Created by deng on 17/11/6.
 */
public class IntegerDemo1 {
    public static void main(String[] args){
//        method();

//        Integer x = new Integer(4);

        Integer x = 4; //自动装箱。//new Integer(4)  多了null值

        x = x+2;//x=2:x进行自动拆箱（x.intValue()）。变成了int类型。和2进行加法运算。
                //再将和进行装箱赋给x，传null值进行运算时会报空指针异常。

        Integer m = 128;
        Integer n = 128;

        sop("m==n:"+(m==n));

        Integer a = 127;
        Integer b = 127;

        sop("a==b:"+(a==b));  //结果为true，因为a和b指向了同一个Integer对象。
                                    //当数值在byte范围内时，对于新特性，如果该数值已经存在，则不会再开辟新的空间。
    }

    public static void method(){
        Integer x= new Integer("123");

        Integer y = new Integer(123);

        sop("x==y:"+(x==y));
        sop("x.equals(y):"+(x.equals(y)));

        sop("x.compareTo(y):"+x.compareTo(y));
    }

    public static void sop(Object obj){
        System.out.println(obj);
    }
}
