package day23;

import java.net.InetAddress;

/**
 * Created by deng on 17/11/30.
 */
public class IPDemo {
    public static void main(String[] args)throws Exception{
        InetAddress i = InetAddress.getLocalHost();
        sop(i.toString());
        sop("address:"+i.getHostAddress());
        sop("name:"+i.getHostName());

//        InetAddress ia = InetAddress.getByName("192.168.1.102");
//        sop("address:"+ia.getHostAddress());
//        sop("name:"+ia.getHostName());

//        InetAddress[] baidu = InetAddress.getAllByName("www.baidu.com");
//        sop("length:"+baidu.length);
//        for (InetAddress ip:baidu){
//            sop(ip.getHostAddress());
//            sop(ip.getHostName());
//        }
    }

    public static void sop(Object obj){
        System.out.println(obj);
    }
}
