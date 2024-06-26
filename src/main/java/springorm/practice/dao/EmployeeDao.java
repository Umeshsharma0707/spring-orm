package springorm.practice.dao;


import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import springorm.practice.entities.Employee;

public class EmployeeDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public int insertEmployee(Employee employee) {
		Integer result = (Integer)this.hibernateTemplate.save(employee);
		
		return result;
	}
	
	// get single data(object)
	
	public Employee getEmployee(int employeeId) {
		Employee employee = this.hibernateTemplate.get(Employee.class, employeeId);
		return employee;
	}
	
	// get all employees object
	
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployees = this.hibernateTemplate.loadAll(Employee.class);
		return allEmployees;
		
	}
	
	// delete employee
	@Transactional
	public void deleteEmployee(int id) {
		Employee employee = this.hibernateTemplate.get(Employee.class, id);
		this.hibernateTemplate.delete(employee);
	}
	
	// update employee
	@Transactional
	public void updateEmployee(Employee employee) {
		this.hibernateTemplate.update(employee);
	}
	
}









