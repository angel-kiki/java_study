package day23;

/**
 * Created by deng on 17/12/1.
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 需求：定义一个应用程序，用于接收udp协议传输的数据并处理的。
 *
 * 思路：
 * 1，定义udp socket服务。
 * 通常会监听一个端口。其实就是给这个接收网络应用程序定义数字标识。方便于明确哪些数据过来该应用程序可以处理。
 * 2，定义一个数据包，因为要存储接收到的字节数据。
 * 因为数据包对象中有更多功能可以提取字节数据中的不同数据信息。
 * 3，通过Socket服务的receive方法将收到的数据存入已定义好的数据包中。
 * 4，通过数据包对象的特有功能，将这些不同的数据取出，打印在控制台上。
 * 5，关闭资源。
 *
 * */

class UdpRece{
    public static void main(String[] args)throws Exception{
        //1,创建udp socket，建立端点。
        DatagramSocket ds = new DatagramSocket(10000);

        //2，定义数据包，用于存储数据。
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf,buf.length);

        //3，通过服务的receive方法将收到数据存入数据包中。
        ds.receive(dp); //阻塞式方法

        //4，通过数据包的方法获取其中的数据。
        String ip = dp.getAddress().getHostAddress();
        String data = new String(dp.getData(),0,dp.getLength());

        int port = dp.getPort();

        System.out.println(ip+"::"+data+"::"+port);

        //5，关闭资源。
        ds.close();

    }
}
