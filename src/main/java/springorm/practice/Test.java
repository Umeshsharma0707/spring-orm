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
		
		Employee employee = new Employee(29,"vijay","java developer");
		Employee employee1 = new Employee(24,"rakesh","web developer");
		int insertedEmployees;
		insertedEmployees = employeeDao.insertEmployee(employee);
		insertedEmployees = employeeDao.insertEmployee(employee1);
		
		System.out.println("total employees inserted : " + insertedEmployees/10);
	}
}
