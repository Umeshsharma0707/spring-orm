package springorm.practice;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springorm.practice.dao.EmployeeDao;
import springorm.practice.entities.Employee;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("springorm/practice/config.xml");
		
		EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
		
		System.out.println("*************************welcome to employee database*************************");
		
		Scanner sc = new Scanner(System.in);
		
		boolean flag = true;
		while (flag == true) {
			System.out.println("PRESS 1 for add new Employee");
			System.out.println("PRESS 2 for display all Employees");
			System.out.println("PRESS 3 for display single Employee");
			System.out.println("PRESS 4 for update Employee");
			System.out.println("PRESS 5 for delete Employee");
			System.out.println("PRESS 6 for exit");
			
			try {
				int input = sc.nextInt();
				switch (input) {
				case 1:
					// add a new Employee
					Employee employee = new Employee();
					System.out.println("enter employee id");
					int id = sc.nextInt();
					employee.setId(id);
					System.out.println("enter employee name");
					String name = sc.next();
					employee.setName(name);
					System.out.println("enter employee job role");
					String jobRole = sc.next();
					employee.setJobRole(jobRole);
					int insertEmployee = employeeDao.insertEmployee(employee);
					System.out.println("Employee inserted at employee_id : " + insertEmployee);
					System.out.println();
					System.out.println("________________________________________________________");
					System.out.println();
					break;
				
				case 2:
					// all employees
					List<Employee> allEmployees = employeeDao.getAllEmployees();
					
					for(Employee e : allEmployees) {
						System.out.println(e);
					}
					System.out.println();
					System.out.println("________________________________________________________");
					System.out.println();
					break;
				
				case 3:
					// single employee
						System.out.println("enter employee id : ");
						int employeeId = sc.nextInt();
						try {
							Employee employee2 = employeeDao.getEmployee(employeeId);
							System.out.println("employee_id : " + employee2.getId());
							System.out.println("Name        : " + employee2.getName());
							System.out.println("Job role    : " + employee2.getJobRole());
						} catch (Exception e) {
							System.out.println("employee_id not found ");
						}
						System.out.println();
						System.out.println("________________________________________________________");
						System.out.println();
					break;
				
				case 4:
					// update employee
						Employee updatedEmployee = new Employee();
						System.out.println("enter employee id");
						int updatedId = sc.nextInt();
						updatedEmployee.setId(updatedId);
						System.out.println("enter employee name");
						String updatedName = sc.next();
						updatedEmployee.setName(updatedName);
						System.out.println("enter employee job role");
						String updatedJobRole = sc.next();
						updatedEmployee.setJobRole(updatedJobRole);
						
						employeeDao.updateEmployee(updatedEmployee);
						System.out.println("Employee updated at employee_id : " + updatedId);
						System.out.println();
						System.out.println("________________________________________________________");
						System.out.println();
						break;
				
				case 5:
					//delete employee
					System.out.println("enter employee_id for delete employee");
						int deleteId = sc.nextInt();
						employeeDao.deleteEmployee(deleteId);
						System.out.println("employee deleted at employee_id : " + deleteId);
						System.out.println();
						System.out.println("________________________________________________________");
						System.out.println();
					break;
				case 6:
					flag = false;;
					System.out.println("ok bye");
					System.out.println("________________________________________________________");
					System.out.println();
					System.out.println("****************************************************************");
					break;

				default:
					System.out.println("invalid input");
					System.out.println();
					System.out.println("________________________________________________________");
					System.out.println();
					break;
				}
			} catch (Exception e) {
				System.out.println("invalid input");
				System.out.println(e.getMessage());
			}
		}

		
		
	}
}
