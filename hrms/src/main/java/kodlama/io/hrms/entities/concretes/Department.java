package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Departments")
public class Department {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="department_name")
	private String departmentName;
	
	public Department() { }

	public Department(int id, String departmentName) {
		this.id = id;
		this.departmentName = departmentName;
	}
	
	

}
