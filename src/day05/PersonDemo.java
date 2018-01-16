package day05;

/**
 * Created by deng on 17/10/19.
 */
class Person{
    private int age;

    public void setAge(int age){
        if (age <= 0){
            System.out.println("输入不合法！");
            System.exit(0);
        }else {
            this.age = age;
            this.speak();
        }
    }

    public int getAge(){
        return this.age;
    }

    void speak(){
        System.out.println("age = "+this.age);
    }
}


public class PersonDemo {
    public static void main(String args[]){
        Person p = new Person();
        p.setAge(20);
        p.setAge(-20);
    }
}
