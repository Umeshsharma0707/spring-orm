package com.spring.orm;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = 
        		new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
        
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
        
		
		  Random r = new Random();
		  
		  int id = r.nextInt(10000,99999);
		      
        
//        int id = 1000;
        
        Student student = new Student(id,"mahesh","Ahmedabad");
        
        studentDao.insert(student);
        
    }
}
