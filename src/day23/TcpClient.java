package day23;

/**
 * Created by deng on 17/12/2.
 *
 * 演示tcp传输。
 * 1，tcp分客户端和服务的。
 * 2，客户端对应的对象是Socket，服务的对应的对象是ServerSocket。
 */

import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端：
 * 通过查阅Socket对象，发现在该对象建立时，就可以去连接指定主机。
 * 因为TCP是面向连接的，所以在建立Socket服务时，就要有服务端存在，并连接成功。
 * 形成通路后，在该通道进行数据的传输。
 *
 * 需求：给服务端发送一个文本数据。
 *
 * 步骤：
 * 1，创建Socket服务。并指定要连接的主机和端口。
 *
 * */
public class TcpClient {
    public static void main(String[] args)throws Exception{
        //创建Socket服务。并指定要连接的主机和端口。
        Socket s = new Socket("192.168.1.5",10003);

        //为了发送数据，应该获取Socket流中的输出流。
        OutputStream out = s.getOutputStream();

        out.write("tcp is coming".getBytes());

        s.close();
    }
}
