package com.spring.orm;

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
        
        Student student = new Student(10,"umesh","Ahmedabad");
        
        studentDao.insert(student);
        
    }
}
