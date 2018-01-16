package day21;

import java.io.Serializable;

/**
 * Created by deng on 17/11/27.
 */
public class Person implements Serializable{
    public static final long serialVersionUID = 42L;

    private String name;
    transient int age;  //加transient可以使成员不序列化
    static String country="cn"; //static成员不会被序列化
    Person(String name,int age,String country){
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String toString(){
        return name+":"+age+":"+country;
    }

}
