package javaEnhance;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

/**
 * Created by deng on 18/1/14.
 *
 * 哈希算法：提供从集合中查找元素的效率，这种方式将集合分成若干个存储取余，每个对象可以计算出一个哈希码，
 *         可以将哈希码分组，每组分别对应某个存储区域，根据一个对象的哈希码就可以确定该对象应该存储在哪个区域。
 *
 * HashSet 采用哈希算法存取对象的集合，它内部采用对某个数字n进行取余的方式对哈希码进行分组和划分对象的存储区域。
 *         Object类中定义了一个hashCode()方法来返回每个Java对象的哈希码，当从HashSet集合中查找某个对象时，
 *         Java系统首先调用对象的hashCode()方法获得该对象的哈希码，然后根据哈希码找到相应的存储区域，最后取出该存储区域内的每个元素与该对象进行equals方法比较，
 *         这样不用遍历集合中的所有元素就可以得到结论。可见，HashSet集合具有很好的对象检索性能。
 *
 *         但是，HashSet集合存储对象的效率相对要低些，因为向HashSet集合中添加一个对象时，要先计算出对象的哈希码和根据这个哈希码确定对象在集合中的位置。
 *
 *         为了保证一个类的实例对象能在HashSet正常存储，要求这个类的两个实例对象用equals()方法比较的结果相等时，它们的哈希码也必须相等。
 *         也就是说，如果obj1.equals(obj2)的结果为true，那么obj1.hashCode()==obj2.hashCode()的结果也要为true.
 *
 *         如果想要比较两个元素值相等，则需要放在同一个区域，即必须算出两个hashCode()值相等。
 *
 *         如果一个类的hashCode()方法没有遵循上述要求，那么，当这个类的两个实例对象用equals()方法比较的结果相等时，他们本来应该无法被同时存储进Set集合中，
 *         但是如果将他们存储进HashSet集合中时，由于他们的hashCode()方法的返回值不同，第二个对象首先按哈希码计算可能会被放进与第一个对象不同的区域中，
 *         这样它就不可能与第一个对象进行equals方法比较了，也就可能被存储进HashSet集合中了。
 *         Object类中的hashCode()方法不能满足对象被存入到HashSet中的要求，因为它的返回值是通过对象的内存地址推算出来的，
 *         同一个对象在程序运行期间的任何时候返回的哈希值都是始终不变的，所以，只要是两个不同的实例对象，即使它们的equals方法比较结果相等，它们默认的hashCode方法的返回值也是不同的。
 *
 *         只有类的实例对象要被采用哈希算法进行存储和检索时，这个类才需要按要求覆盖hashCode方法。
 *         即使程序可能暂时不会用的当前类的hashCode方法，但是为它提供一个hashCode方法也不会有什么不好，没准以后什么时候又用到这个方法了。
 *         所以，通常要求hashCode方法和equals方法一并被同时覆盖。
 *
 *         只有存储集合是HashSet时hashCode()才有用，如果是ArrayList，算出hashCode()值没有用。
 *
 *         提示：
 *         1、通常来说，一个类的两个实例对象用equals方法比较的结果相等时，他们的哈希码也必须相等，但是反之则不成立，
 *            即equals方法比较结果不相等的对象可以有相同的哈希码，或者说哈希码相同的两个对象的equals方法比较的结果可以不等，
 *            例如，字符串"BB"和"Aa"的equals方法比较结果肯定不相等，但他们的hashCode方法返回值却相等。
 *         2、当一个对象被存储进HashSet集合中以后，就不能修改这个对象中那些参与计算哈希值的字段了，否则，对象修改后的哈希值与最初存储进HashSet集合中的哈希值就不同了，
 *            这种情况下，即使在contains方法使用该对象的当前引用作为的参数去HashSet集合中检索对象，也将返回找不到对象的结果，
 *            这就会导致无法从HashSet集合中单独删除当前对象，从而造成内存泄漏。
 */
public class ReflectTest2 {
    public static void main(String[] args) throws Exception{

////        Collection collections = new ArrayList();
//        Collection collections = new HashSet();
//        ReflectPoint pt1 = new ReflectPoint(3,3);
//        ReflectPoint pt2 = new ReflectPoint(5,5);
//        ReflectPoint pt3 = new ReflectPoint(3,3);
//        collections.add(pt1);
//        collections.add(pt2);
//        collections.add(pt3);
//        collections.add(pt1);
//
//        pt1.y = 7;
//        collections.remove(pt1);  //删除不了，因为hashcode值变了，这样可以造成内存泄漏
//
//        System.out.println(collections.size());

        //用反射即使开发框架
        //配置文件一定要记住用完整的路径，但完整的路径不是硬编码，而是运算出来的。
//        InputStream ips = new FileInputStream("config.properties");

//        InputStream ips = ReflectTest2.class.getClassLoader().getResourceAsStream("javaEnhance/config.properties");
//        InputStream ips = ReflectTest2.class.getResourceAsStream("resources/config.properties");
        InputStream ips = ReflectTest2.class.getResourceAsStream("/javaEnhance/resources/config.properties");

        Properties props = new Properties();
        props.load(ips);
        ips.close();//变量被垃圾回收之前先关闭变量所关联的操作系统资源

        String className = props.getProperty("className");
        Collection collections = (Collection) Class.forName(className).newInstance();

        ReflectPoint pt1 = new ReflectPoint(3,3);
        ReflectPoint pt2 = new ReflectPoint(5,5);
        ReflectPoint pt3 = new ReflectPoint(3,3);
        collections.add(pt1);
        collections.add(pt2);
        collections.add(pt3);
        collections.add(pt1);

        System.out.println(collections.size());
    }
}
