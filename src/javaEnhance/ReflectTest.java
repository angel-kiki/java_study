package javaEnhance;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by deng on 18/1/13.
 *
 * 反射
 */
public class ReflectTest {
    public static void main(String[] args)throws Exception{
        String str1 = "abc";

        Class cl1 = str1.getClass();
        Class cl2 = String.class;
        Class cl3 = Class.forName("java.lang.String");
        System.out.println(cl1 == cl2);
        System.out.println(cl1 == cl3);
        System.out.println(cl2 == cl3);

        System.out.println(cl1.isPrimitive());

        System.out.println(int.class.isPrimitive());
        System.out.println(int.class == Integer.class);
        System.out.println(int.class == Integer.TYPE);
        System.out.println(int[].class.isPrimitive());
        System.out.println(int[].class.isArray());

        //构造方法的反射应用：反射会降低性能（先缓存再用，如果功能不复杂，直接用就好了，先缓存起来反而浪费时间）
        //通常方式：new String(new StringBuffer("abc"));
        Constructor constructor1 = String.class.getConstructor(StringBuffer.class);
        String str2 = (String) constructor1.newInstance(new StringBuffer("abc"));//反射方式
        System.out.println(str2.charAt(2));

        //成员变量的反射
        ReflectPoint pt1 = new ReflectPoint(3,5);
        Field fieldY = pt1.getClass().getField("y");
        //fieldY的值是多少？是5，错！fieldY不是对象身上的变量，而是类上，要用它去取某个对象上对应的值
        System.out.println(fieldY.get(pt1));

//        Field fieldX = pt1.getClass().getField("x");//私有变量不能用getField
        Field fieldX = pt1.getClass().getDeclaredField("x");
        fieldX.setAccessible(true);  //暴力反射
        System.out.println(fieldX.get(pt1));

        //练习：将一个字符串中所有的b转换成a
        changeStringValue(pt1);
        System.out.println(pt1);

        //成员方法的反射
        //普通方式：str1.charAt(1);
        Method methodCharAt = String.class.getMethod("charAt", int.class);
        System.out.println(methodCharAt.invoke(str1, 1));//反射方式。
        // 如果传递给Method对象的invoke()方法的第一个参数是null，说明该Method对象对应的是一个静态方法！

        System.out.println(methodCharAt.invoke(str1, new Object[]{2}));//java1.4反射方式。

//        //对接收数组参数的成员方法进行反射（用反射方式执行某个类中的main方法）
//        //目标：写一个程序，这个程序能够根据用户提供的类名，去执行该类中的main方法。
////        TestArguments.main(new String[]{"111","222","333"});//普通方式：用静态代码方式调用
//        //用反射方式调用
//        String startingClassName = args[0];
//        Method mainMethod = Class.forName(startingClassName).getMethod("main",String[].class);
//
//        //启动java程序的main方法的参数是一个字符串数组，即public static void main(String[] args)，通过反射方式来调用这个main方法时，
//        //如何为invoke方法传递参数呢？按照jdk1.5的语法，整个数组是一个参数，而按jdk1.4的语法，数组中的每个元素对应一个参数，
//        // 当把一个字符串数组作为参数传递给invoke方法时，javac会按jdk1.4的语法进行处理（原因：jdk1.5要兼容jdk1.4的语法）,
//        // 即把数组打散成为若干个单独的参数。所以，在给main方法传递参数时，不能使用代码mainMethod.invoke(null, new String[]{"XXX"})，
//        // javac只把它当做jdk1.4的语法进行理解，而不把它当做jdk1.5的语法解释，因此会出现参数类型不对的问题。
////        mainMethod.invoke(null, new String[]{"111","222","333"});//报错，参数个数不一致，原因是会拆包，拆成多个参数。数组不会当做参数，而是把其中的内容当做参数。
//        mainMethod.invoke(null, new Object[]{new String[]{"111","222","333"}});//解决办法1，再打包
//        mainMethod.invoke(null, (Object)new String[]{"111","222","333"});//解决办法2，告诉编译器不拆包。
//        // 这种情况下编译器会作特殊处理，编译时不把参数当做数组看待，也就不会把数组打散成若干个参数了。

        //数组与Object的关系及其反射类型
        int[] a1 = new int[]{1,2,3};
        int[] a2 = new int[4];
        int[][] a3 = new int[2][3];
        String[] a4 = new String[]{"a","b","c"};
        System.out.println(a1.getClass() == a2.getClass());//true，数组元素类型及维度相同，则得到的字节码是相同的
//        System.out.println(a1.getClass() == a4.getClass());//false，类型不同
//        System.out.println(a1.getClass() == a3.getClass());//false，维数不同
        System.out.println(a1.getClass().getName());
        System.out.println(a1.getClass().getSuperclass().getName());
        System.out.println(a4.getClass().getSuperclass().getName());

        Object aObj1 = a1;
        Object aObj2 = a4;
//        Object[] aObj3 = a1;  //int[]不能赋值给Object数组对象Object[]
        Object[] aObj4 = a3;
        Object[] aObj5 = a4;

        System.out.println(a1);
        System.out.println(a4);
        //Arrays.asList处理int[]和Sting[]的差异
        System.out.println(Arrays.asList(a1));  //将数组作为一个参数放进List后返回
        System.out.println(Arrays.asList(a4));  //将数组里的元素取出后放进List后返回

        //数组的反射应用：Arrays工具类用于完成对数组的反射操作
        printObject(a4);
        printObject("xyz");


        //思考：怎么得到数组中的元素类型？
        //需要取出每个元素对象，然后再对每个对象进行判断，因为其中每个具体元素的类型都可以不同
        //例如：Object[] x = new Object[]{"abc",Integer.Max}
    }

    private static void printObject(Object obj) {
        Class clazz = obj.getClass();
        if (clazz.isArray()){
            int len = Array.getLength(obj);
            for (int i=0;i<len;i++){
                System.out.println(Array.get(obj,i));
            }
        }else {
            System.out.println(obj);
        }
    }

    private static void changeStringValue(Object obj) throws Exception{
        Field[] fields = obj.getClass().getFields();
        for (Field field: fields){
            if (field.getType() == String.class){
                String oldValue = (String)field.get(obj);
                String newValue = oldValue.replace('b','a');
                field.set(obj, newValue);
            }
        }
    }
}

class TestArguments{
    public static void main(String[] args){
        for (String arg: args){
            System.out.println(arg);
        }
    }
}
