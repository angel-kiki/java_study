package day24;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by deng on 17/12/17.
 *
 * 演示客户端和服务端。
 * 1，
 * 客户端：浏览器(telnet)
 * 服务端：自定义
 *
 * 2，
 * 客户端：浏览器
 * 服务器：Tomcat服务器
 */
public class ServerDemo {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(11000);

        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostAddress());

        PrintWriter out = new PrintWriter(s.getOutputStream(),true);

        out.println("<font color='red' size='7'>客户端你好</font>");

        s.close();

        ss.close();


    }
}
