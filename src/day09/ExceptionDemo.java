package day09;

/**
 * Created by deng on 17/10/28.
 *
 * 自定义异常。
 * 当在函数内部出现了throw抛出异常对象，那么就必须要给对应的处理动作。
 * 要么在函数内部try catch处理
 * 要么在函数上声明让调用者处理。
 *
 * 一般情况下，函数内出现异常，函数上需要声明。
 *
 * 发现打印的结果只有异常的名称，却没有异常的信息。因为自定义的异常并未定义信息。
 *
 * 如何定义异常信息呢？
 * 因为父类中已经把异常信息的操作都完成了，
 * 所以子类只要在构造时，将异常信息通过super语句传递给父类，
 * 那么就可以直接通过getMessage方法获取自定义的异常信息
 *
 * 自定义异常：
 * 必须是自定义类继承Exception。
 *
 * 继承Exception原因：
 * 异常体系有一个特点：因为异常类和异常对象都被抛出。
 * 他们都具备可抛性。这个可抛性是Throwable这个体系中独有的特点。
 * 只有这个体系中的类和对象才可以被throws和throw操作。
 *
 * throws和throw的区别：
 * throws使用在函数上。
 * throw使用在函数内。
 *
 * throws后面跟的异常类。可以跟多个，用逗号隔开。
 * throw后跟的是异常对象。
 */
class FushuException extends Exception{ //getMessage();
    private int value;

    FushuException(){

    }

    FushuException(String msg, int value){
        super(msg);
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }


}

class Demo{
    int div(int a,int b) throws FushuException{
        if(b<0){
            throw new FushuException("出现了除数是负数的情况 / by fushu",b); //手动通过throw关键字抛出一个自定义异常对象。
        }
        return a/b;
    }
}
public class ExceptionDemo {
    public static void main(String [] args){
        Demo d = new Demo();
        try {
            int x = d.div(2,-1);
            System.out.println("x = "+x);
        }catch (FushuException e){
            System.out.println(e.toString());
            System.out.println("负数是："+e.getValue());
        }

        System.out.println("over");
    }
}
