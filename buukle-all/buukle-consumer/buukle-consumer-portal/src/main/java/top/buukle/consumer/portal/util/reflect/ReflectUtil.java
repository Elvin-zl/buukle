package top.buukle.consumer.portal.util.reflect;

import top.buukle.consumer.portal.entity.AsyncTask;

import java.lang.reflect.Method;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description :
 */
public class ReflectUtil {

    public static void invoke(AsyncTask task) throws Exception{
        Class<?> aClass = Class.forName(task.getClassName());
        Object obj = aClass.newInstance();
        Method method = aClass.getDeclaredMethod(task.getMethodName(),String.class);
        method.invoke(obj, new String[]{task.getParameter()});
    }

//    public void test(String i ){
//        System.out.println(i);
//    }
//
//    public static void main(String[] args) throws Exception {
//        AsyncTask asyncTask = new AsyncTask();
//        asyncTask.setClassName("top.buukle.consumer.portal.util.reflect.ReflectUtil");
//        asyncTask.setMethodName("test");
//        asyncTask.setParameter("222222222");
//        invoke(asyncTask);
//    }
}



