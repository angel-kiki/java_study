package day10;

/**
 * Created by deng on 17/10/29.
 *
 * 总结：
 *      包与包之间进行访问，被访问的包中的类以及类中的成员，需要public修饰。
 *
 *      不同包中的子类还可以直接访问父类中被protected权限修饰的成员。
 *
 * 包与包之间可以使用的权限只要两种：public，protected。
 *
 *            public   protected   default   private
 * 同一个类中     ok         ok         ok        ok
 * 同一个包中     ok         ok         ok
 * 子类          ok         ok
 * 不同包中       ok
 *
 */
public class PackageDemo {
}
