package day10;

/**
 * Created by deng on 17/10/28.
 * 异常在子父类覆盖中的体现：
 * 1，子类在覆盖父类时，如果父类的方法抛出异常，那么子类的覆盖方法，只能抛出父类的异常或者该异常的子类，或者不抛。
 *      如果子类真的会出现新的异常，那么只能try处理，不能抛。
 * 2，如果父类方法抛出多个异常，那么子类在覆盖该方法时，只能抛出父类异常的子集。
 * 3，如果父类或者接口的方法中没有异常抛出，那么子类在覆盖方法时，也不可以抛出异常。
 *      如果子类方法发出了异常，就必须要进行try处理，绝对不能抛。
 */
class AException extends Exception{

}
class BException extends AException{

}
class CException extends Exception{

}
class Fu{
    void show() throws AException
    {

    }
}
class Zi extends Fu{
    void show() throws AException //或者BException，或者不抛，但不能抛Exception和CException
    {

    }
}
public class ExceptionDemo2 {
    public static void main(String [] args){

    }
}
