package com.spring.orm.dao;





import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}




	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void insert(Student student) {
		this.hibernateTemplate.save(student);
		
	}
}
