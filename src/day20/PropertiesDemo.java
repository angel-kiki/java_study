package day20;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * Created by deng on 17/11/26.
 * Properties是hashtable的子类
 * 也就是是它具备map集合的特点，而且它里面存储的键值对都是字符串
 *
 * 是集合中合IO技术相结合的集合容器。
 * 该对象的特点：可以用于键值对形式的配置文件。
 *
 * 那么在加载数据时，需要数据有固定格式：键=值
 *
 */
public class PropertiesDemo {
    public static void main(String[] agrs) throws IOException{
//        setAndGet();
//        method_1();
        loadDemo();
    }

    public static void loadDemo()throws IOException{
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("test.txt");
        //将流中的数据加载进集合。
        prop.load(fis);
//        sop(prop);
//        prop.list(System.out);

        prop.setProperty("wangwu","39");

        FileOutputStream fos = new FileOutputStream("test.txt");
        prop.store(fos,"modify");

        fos.close();
        fis.close();

        prop.list(System.out);
    }

    //演示：如何将流中的数据存储到集合中。
    //想要将test.txt中键值数据存到集合中进行操作
    /**
     * 1,用一个流和test.txt文件关联。
     * 2，读取一行数据，将该行数据用"="进行切割。
     * 3，等号左边作为键，右边作为值。存入到Properties集合中即可。
     *
     * */
    public static void method_1() throws IOException{
        BufferedReader bufr = new BufferedReader(new FileReader("test.txt"));
        String line = null;
        Properties prop = new Properties();
        while ((line = bufr.readLine())!=null){
            String[] arr = line.split("=");
//            sop(arr[0]+"...."+arr[1]);
            prop.setProperty(arr[0],arr[1]);
        }
        bufr.close();

        sop(prop);

    }

    //设置和获取元素
    public static void setAndGet(){
        Properties prop = new Properties();

        prop.setProperty("zhangsan","30");
        prop.setProperty("lisi","39");

//        sop(prop);

        String value = prop.getProperty("lisi");
//        sop(value);
        prop.setProperty("lisi",89+"");

        Set<String> names = prop.stringPropertyNames();
        for (String s:names){
            sop(s);
            sop(s+":"+prop.getProperty(s));
        }


    }

    public static void sop(Object obj){
        System.out.println(obj);
    }
}
