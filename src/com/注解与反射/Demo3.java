package com.注解与反射;
/*
*通过反射API动态操作构造器方法属性
*
 */

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo3 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        String path = "com.注解与反射.Dog";
        Class<?> aClass = Class.forName(path);

        //struct class dynamic by reflected
        Dog o = (Dog) aClass.getConstructor(null).newInstance();

        //get and set the object's field by using it's method
        o.setName("new name");
        System.out.println(o.name);
        Method method = aClass.getMethod("setName",String.class);
        //to activate the method and use it
        method.invoke(o,"new new name");
        Method method1 = aClass.getMethod("getName",null);
        System.out.println(method1.invoke(o,null));

        //获取对象的属性值
        Field field = aClass.getDeclaredField("age");
        //不经检测安全性直接读取 ， 可以忽略掉private
        field.setAccessible(true);
        System.out.println(field.get(o));


    }

}
