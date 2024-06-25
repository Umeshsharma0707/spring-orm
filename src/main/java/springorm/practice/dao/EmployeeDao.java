package springorm.practice.dao;

import java.io.Serializable;

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
}
