package day21;

import java.io.*;

/**
 * Created by deng on 17/11/27.
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws Exception{
//        writeObj();
        readObj();
    }

    public static void readObj() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));

        Person p = (Person)ois.readObject();
        System.out.println(p);
        ois.close();
    }

    public static void writeObj() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));

        oos.writeObject(new Person("lisi",39,"kr"));

        oos.close();
    }
}
