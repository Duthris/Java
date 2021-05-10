package kodlama.io.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="Companies")
public class Company {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="activation_status")
	private boolean activationStatus;
	
	@Column(name="activate_date")
	private Date activateDate;
	
	public Company() { }

	public Company(int id, String companyName, boolean activationStatus, Date activateDate) {
		this.id = id;
		this.companyName = companyName;
		this.activationStatus = activationStatus;
		this.activateDate = activateDate;
	}
	
	

}
