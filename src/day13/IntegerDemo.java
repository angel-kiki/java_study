package day13;

/**
 * Created by deng on 17/11/5.
 * 基本数据类型对象包装类。
 *
 * byte    Byte
 * short   short
 * int     Integer
 * long    Long
 * boolean Boolean
 * float   Float
 * double  Double
 * char    Character
 *
 * 基本数据类型对象包装类的最常见作用，就是用于基本数据类型和字符串类型之间做转换
 *
 * 基本数据类型转换成字符串。
 *
 *      基本数据类型+""
 *
 *      基本数据类型.toString(基本数据类型值);
 *
 *      如：Integer.toString(34); //将34整数变成"34";
 *
 *      String.valueOf(基本数据类型值);//String类中的静态方法ValueOf
 *
 * 字符串转成基本数据类型。
 *      1，使用包装类中的静态方法parseXxx方法
 *      xxx a = xxx.parseXxx(String);
 *
 *      int a = Integer.parseInt("123");
 *
 *      double a = Double.parseDouble("12.1");
 *
 *      boolean a = Boolean.parseBoolean("true");
 *      只有Character没有parse方法
 *
 *      2，如果字符串被Integer进行对象的封装。
 *      可使用另一个非静态的方法，intValue();将一个Integer对象转成基本数据类型值。
 *
 *      Integer i = new Integer("123");
 *
 *      int num = i.intValue();
 *
 *
 *
 *
 * 十进制转成其他进制。
 *      toBinaryString();
 *      toHexString();
 *      toOctalString();
 *
 * 其他进制转成十进制。
 *      parseInt(String,radix);
 */
public class IntegerDemo {
    public static void sop(Object obj){
        System.out.println(obj);
    }
    public static void main(String[] args){
        //整数类型的最大值。
        sop("int max :"+Integer.MAX_VALUE);

        //将一个字符串转成整数。
//        int num = Integer.parseInt("123");
//        long x = Long.parseLong("123");

//        sop("num="+(num+4));
//        sop("x="+x);

//        //十进制转换成二进制
//        sop(Integer.toBinaryString(60));
//        //十进制转换成八进制
//        sop(Integer.toOctalString(60));
//        //十进制转换成十六进制
//        sop(Integer.toHexString(60));
//
//        //十进制转换成指定进制的另一种方法
//        sop(Integer.toString(60,2));
//        sop(Integer.toString(60,8));
//        sop(Integer.toString(60,16));

        //其他进制-》十进制
        int x = Integer.parseInt("110",2);
        sop("x="+x);

        int y = Integer.parseInt("3c",16);
        sop("y="+y);
//
//        //基本数据类型转换成字符串
//        sop(4+"abc");
//        sop(String.valueOf(4));

    }
}
