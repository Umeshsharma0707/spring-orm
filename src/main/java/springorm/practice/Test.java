package springorm.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springorm.practice.dao.EmployeeDao;
import springorm.practice.entities.Employee;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("springorm/practice/config.xml");
		
		EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
		
		Employee employee = new Employee(12,"shivam","java developer");
		
		int r = employeeDao.insertEmployee(employee);
		
		System.out.println("total rows inserted : " + r/10);
	}
}
