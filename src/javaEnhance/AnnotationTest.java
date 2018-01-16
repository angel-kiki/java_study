package javaEnhance;

/**
 * Created by deng on 18/1/15.
 */
@ItcastAnnotation(annotationAttr = @MetaAnnotation("dhp"), color = "red", value = "abc", arrayAttr = {1,2,3})//如果数组中只有一个元素，大括号可以省略
public class AnnotationTest {
    @SuppressWarnings("deprecation")
    @ItcastAnnotation("xyz")
    public static void main(String[] args){
        System.runFinalizersOnExit(true);

        if (AnnotationTest.class.isAnnotationPresent(ItcastAnnotation.class)){
            ItcastAnnotation annotation = (ItcastAnnotation)AnnotationTest.class.getAnnotation(ItcastAnnotation.class);
            System.out.println(annotation);
            System.out.println(annotation.color());
            System.out.println(annotation.value());
            System.out.println(annotation.arrayAttr().length);
            System.out.println(annotation.lamp().nextLamp().name());
            System.out.println(annotation.annotationAttr().value());

        }

    }

    @Deprecated
    public static void sayHello(){
        System.out.println("hello,world");
    }
}
