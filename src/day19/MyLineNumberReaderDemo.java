package day19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by deng on 17/11/16.
 * 练习：模拟一个带行号的缓冲区对象
 *
 *
 */

class MyLineNumberReader extends MyBufferedReader{
    private int lineNumber;

    public MyLineNumberReader(Reader r) {
        super(r);
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String myReadLine() throws IOException{
        lineNumber++;
        return super.myReadLine();
    }
}

/*
class MyLineNumberReader {
    private Reader r;
    private int lineNumber;

    public MyLineNumberReader(Reader r) {
        this.r = r;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String myReadLine(){
        lineNumber++;
        StringBuilder sb = new StringBuilder();
        int ch =0;
        try {
            while ((ch=r.read())!=-1){
                if (ch=='\r')
                    continue;
                if (ch=='\n')
                    return sb.toString();
                else
                    sb.append((char)ch);
            }
        } catch (IOException e) {
            System.out.println("文件读取失败！");
        }
        if (sb.length()!=0)
            return sb.toString();
        return null;
    }

    public void myClose() throws IOException{
        r.close();
    }
}
*/
public class MyLineNumberReaderDemo {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("javaTest_copy.iml");
        MyLineNumberReader mylnr = new MyLineNumberReader(fr);
        String line = null;
        mylnr.setLineNumber(100);
        while ((line=mylnr.myReadLine())!=null){
            System.out.println(mylnr.getLineNumber()+"::"+line);
        }
        mylnr.myClose();
    }

}
