package com.example.documentservice.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ActionSchedule {

    public static void createActionSchedule(List<? extends Person> dataList) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<?> classObj=dataList.get(0).getClass();
        String simpleClassName=classObj.getSimpleName().toLowerCase();
        String methodName=simpleClassName.concat("Method");
        System.out.println("Class Name ::: "+simpleClassName + " Method Name ::: "+methodName);

        ActionSchedule obj=new ActionSchedule();
        Class<?> cls=obj.getClass();
        Method invokeMethod=cls.getDeclaredMethod(methodName,classObj);
        invokeMethod.invoke(obj,dataList.get(0));

    }

    public static void studentMethod(Student student)
    {
        System.out.println(student.getPersonCategory());
        System.out.println(student.getName());
        System.out.println("Inside Student Method");
    }

    public static void teacherMethod(Teacher teacher)
    {
        System.out.println(teacher.getPersonCategory());
        System.out.println("Inside Teacher Method");

    }

    public static void watchmanMethod(Watchman watchman)
    {
        System.out.println(watchman.getPersonCategory());
        System.out.println("Inside Watchman Method");
    }
}
