package javaEnhance;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by deng on 18/1/14.
 *
 * JavaBean的內省操作
 */
public class IntroSpectorTest {
    public static void main(String[] args) throws Exception{
        ReflectPoint pt1 = new ReflectPoint(3,5);

        String propertyName = "x";
        Object retVal = getProperty(pt1, propertyName);
        System.out.println(retVal);

        int value = 7;
        setProperties(pt1, propertyName, value);

        System.out.println(BeanUtils.getProperty(pt1, "x").getClass().getName());
        BeanUtils.setProperty(pt1,"x","9");
        System.out.println(pt1.getX());

        Map map = new HashMap();
        map.put("name","aaa");
        map.put("age",18);
        BeanUtils.setProperty(map,"name","bbb");
        System.out.println(BeanUtils.getProperty(map,"name"));

        BeanUtils.setProperty(pt1, "birthday.time","111");
        System.out.println(BeanUtils.getProperty(pt1,"birthday.time"));

        //PropertyUtils中参数必须与bean中类型一致
        PropertyUtils.setProperty(pt1,"x",8);
        System.out.println(PropertyUtils.getProperty(pt1,"x").getClass().getName());

    }

    //代码抽取
    public static void setProperties(Object pt1, String propertyName, int value) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        PropertyDescriptor pd2 = new PropertyDescriptor(propertyName,pt1.getClass());
        Method methodSetX = pd2.getWriteMethod();
        methodSetX.invoke(pt1,value);
    }

    public static Object getProperty(Object  pt1, String propertyName) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        //简单操作
//        PropertyDescriptor pd = new PropertyDescriptor(propertyName,pt1.getClass());//得到BeanInfo最好采用"obj.getClass()"方式，而不要采用"类名.class"方式，这样程序更通用
//        Method methodGetX = pd.getReadMethod();
//        Object retVal = methodGetX.invoke(pt1);

        //复杂操作
        BeanInfo beanInfo = Introspector.getBeanInfo(pt1.getClass());
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        Object retVal = null;
        for (PropertyDescriptor pd:pds){
            if (pd.getName().equals(propertyName)){
                Method methodGetX = pd.getReadMethod();
                retVal = methodGetX.invoke(pt1);
                break;
            }
        }

        return retVal;
    }
}
