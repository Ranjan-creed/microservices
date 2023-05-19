package com.example.documentservice;

import com.example.documentservice.test.ActionSchedule;
import com.example.documentservice.test.Person;
import com.example.documentservice.test.Student;
import com.example.documentservice.test.Watchman;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
public class DocumentServiceApplication {

	private static Map<String,List<? extends Person>> dataMap=new HashMap<>();
	public static void setElement(String type) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Class cls=Class.forName(type);
		Object obj=cls.newInstance();
		List<Student> studentList=new ArrayList<>();
		dataMap.put(type,studentList);

	}
	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, ClassNotFoundException, InstantiationException {

		String type="com.example.documentservice.test.Student";
		setElement(type);

		Student student=new Student();
		student.setName("Ranjan");

		Watchman watchman=new Watchman();
		watchman.setName("Asit");

		List<Student>students= (List<Student>) dataMap.get(type);
		students.add(student);
		//students.add(watchman);
		System.out.println("dataMap::: "+ dataMap);
		ActionSchedule.createActionSchedule(students);
		//ActionSchedule.createActionSchedule(teachers);
		//ActionSchedule.createActionSchedule(watchmens);

		//SpringApplication.run(DocumentServiceApplication.class, args);
	}

}
