package day23;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by deng on 17/12/1.
 */
public class UdpRece2 {
    public static void main(String[] args)throws Exception{
        DatagramSocket ds = new DatagramSocket(10001);
        while (true){
            byte[] buf = new byte[1024];

            DatagramPacket dp = new DatagramPacket(buf,buf.length);

            ds.receive(dp);

            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(),0,dp.getLength());

            int port = dp.getPort();

            System.out.println(ip+"::"+data+"::"+port);

        }
    }
}
