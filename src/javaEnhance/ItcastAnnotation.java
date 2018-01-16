package javaEnhance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by deng on 18/1/16.
 * 元注解
 * 元数据
 * 元信息
 *
 * @Retention(RetentionPolicy.RUNTIME)
 * RetentionPolicy.SOURCE、RetentionPolicy.CLASS、RetentionPolicy.RUNTIME
 * 分别对应：java源文件--》class文件--》内存中的字节码。默认值是：RetentionPolicy.CLASS
 *
 * @Override 对应的Retention属性值是SOURCE
 * @SuppressWarning 对应的Retention属性值是SOURCE
 * @Deprecated 对应的Retention属性值是RUNTIME
 *
 * @Target({ElementType.METHOD,ElementType.TYPE}):
 * ElementType.METHOD:代表这个注解只能使用在方法上面
 * ElementType.TYPE：代表这个注解能使用在类上，TYPE是class的父类。
 */

@Retention(RetentionPolicy.RUNTIME)//一直保留到运行期间
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface ItcastAnnotation {
    String color() default "blue";//属性默认值
    String value(); //value()属性的特殊性，可以直接给值，不加value=
    int[] arrayAttr() default {3,4,4};

    EnumTest.TrafficLamp lamp() default EnumTest.TrafficLamp.RED;
    MetaAnnotation annotationAttr() default @MetaAnnotation("1hm");


}
