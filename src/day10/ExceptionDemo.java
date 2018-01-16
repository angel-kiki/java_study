package day10;

/**
 * Created by deng on 17/10/28.
 * 异常的三种格式：
 * 第一种格式：
 * try{
 *
 * }catch{
 *
 * }
 * 第二种格式：
 * try{
 *
 * }catch{
 *
 * }finally{
 *
 * }
 * 第三种格式：
 * try{
 *
 * }finally{
 *
 * }
 *
 * 记住一定：catch用于处理异常。如果没有catch就代表异常没有被处理过，如果该异常是检测时异常，那么必须声明。
 */
class FushuException extends Exception{
    FushuException(String msg){
        super(msg);
    }

}

class Demo{
    int div(int a,int b) throws FushuException {
        if(b<0){
            throw new FushuException("出现了除数是负数的情况 / by fush");
        }
        return a/b;
    }
}
class ExceptionDemo {
    public static void main(String [] args){
        Demo d = new Demo();
        try {
            int x = d.div(2,-1);
            System.out.println("x = "+x);
        }catch (FushuException e){
            System.out.println(e.toString());
            return;
        }finally {
            System.out.println("finally");//finally存放的是一定会被执行的代码
        }

        System.out.println("over");
    }
}
