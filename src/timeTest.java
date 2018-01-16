import java.util.Date;

/**
 * Created by deng on 17/8/23.
 */
public class timeTest {
    public static void main(String args[]) {
        // 初始化 Date 对象
        Date date = new Date();

        // 使用 toString() 函数显示日期时间
        System.out.println(date.toString());

        //获得日期对应的毫秒时间戳
        print(date.getTime());

        Date date1 = new Date(2018,2,12);
        Date date2 = new Date(1503448716);
        print(date1.after(date2));
        print(date.after(date2));
        print(date1.before(date2));
        print(date1.equals(date2));
        print(date.equals(date2));
        print(date1.compareTo(date2));
        print(date2.compareTo(date1));
    }

    public static void print(Object o){
        System.out.println(o);
    }
}