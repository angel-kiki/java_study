import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端。
 * 1，服务端点
 * 2，读取客户端已有的图片数据
 * 3，通过socket输出流将数据发给服务端
 * 4，读取服务端反馈信息。
 * 5，关闭。
 *
 *
 * */
class PicClient {
    public static void main(String[] args)throws Exception{
        if (args.length!=1){
            System.out.println("请选择一个jpg格式的图片");
            return;
        }

        File file = new File(args[0]);

        if (!(file.exists()&&file.isFile())){
            System.out.println("该文件有问题，要么不存在，要么不是文件");
            return;
        }

        if (file.getName().endsWith(".jpg")){
            System.out.println("图片格式错误，请重新选择");
            return;
        }

        if (file.length()>1024*1024*5){
            System.out.println("文件过大，无法上传");
            return;
        }

        Socket s = new Socket("192.168.1.5",10007);

        FileInputStream fis = new FileInputStream(file);

        OutputStream out = s.getOutputStream();

        byte[] buf = new byte[1024];

        int len = 0;

        while ((len=fis.read(buf))!=-1){
            out.write(buf,0,len);
        }

        //告诉服务端数据已写完
        s.shutdownOutput();

        InputStream in = s.getInputStream();

        byte[] bufIn = new byte[1024];

        int num = in.read(bufIn);

        System.out.println(new String(bufIn,0,num));

        fis.close();
        s.close();
    }
}


/**
 * 服务端
 *
 * 这个服务端有个局限性。当A客户端连接上以后，被服务端获取到，服务端执行具体流程。
 * 这时B客户端连接，只有等待。
 * 因为服务端还没有处理完A客户端的请求，还有循环回来执行下车accept方法。
 * 所以暂时获取不到b客户端对象。
 *
 * 那么为了可以让多个客户端同时并发访问服务端。
 * 那么服务端最后就是将美国客户端封装到一个单独的线程中，这样就可以同时处理多个客户端请求。
 *
 * 如何定义线程呢？
 *
 * 只要明确了每一个客户端要在服务端执行的代码即可。将该代码存入run方法中。
 * */

class PicThread implements Runnable{
    private Socket s;
    PicThread(Socket s){
        this.s = s;
    }
    @Override
    public void run() {
        int count = 1;
        String ip = s.getInetAddress().getHostAddress();
        try {
            System.out.println(ip+"....connected");
            InputStream in = s.getInputStream();

            File file = new File(ip+".jpg");

            while (file.exists())
                file = new File(ip+"("+(count++)+")"+"jpg");

            FileOutputStream fos = new FileOutputStream(file);

            byte[] buf = new byte[1024];

            int len = 0;

            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }

            OutputStream out = s.getOutputStream();

            out.write("上传成功".getBytes());

            fos.close();
            s.close();

        }catch (Exception e){
            throw new RuntimeException(ip+"上传失败");

        }

    }
}


class PicServer{
    public static void main(String[] args)throws Exception{
        ServerSocket ss = new ServerSocket(10007);

        while (true) {
            Socket s = ss.accept();

            new Thread(new PicThread(s)).start();



        }
//        ss.close();
    }

}


