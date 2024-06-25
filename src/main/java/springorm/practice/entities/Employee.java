package springorm.practice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "employee_id")
	int id;
	@Column(name = "employee_name")
	String name;
	@Column(name = "job_role")
	String jobRole;
	public Employee(int id, String name, String jobRole) {
		super();
		this.id = id;
		this.name = name;
		this.jobRole = jobRole;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", jobRole=" + jobRole + "]";
	}
	
	
}
