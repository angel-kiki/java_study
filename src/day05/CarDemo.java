package day05;

/**
 * Created by deng on 17/10/19.
 */

class Car{
    String color = "blue";
    Integer num = 4;
    public void run(){
        System.out.println("color..."+color+"\tnum..."+num.toString());
    }
}

public class CarDemo extends Car{
    public static void main(String args[]){
//        day05.Car c = new day05.Car();
//        c.run();
//
//        day05.Car c1 = new day05.Car();
//        c1.color = "green";
//        c1.run();
//
//        new day05.Car().run();


        Car c = new Car();
        show(c);

        show(new Car());
    }

    public static void show(Car c){
        c.num = 3;
        c.color = "black";
        c.run();
    }

}


//强引用、弱引用、软引用、虚引用？？
