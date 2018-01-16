package javaEnhance;

/**
 * Created by deng on 18/1/6.
 */
import static java.lang.Math.max;
//import static java.lang.Math.*;
public class StaticImport {
    public static void main(String[] args){
        AnnotationTest.sayHello();

        System.out.println(max(1,2));
        System.out.println(Math.abs(-5));

    }
}
