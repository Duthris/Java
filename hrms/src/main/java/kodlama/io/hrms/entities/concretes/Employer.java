package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Employers")
public class Employer {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="hrms_verification_status")
	private boolean hrmsVerificationStatus;
	
	public Employer() { }

	public Employer(int id, String companyName, String website, String phoneNumber, boolean hrmsVerificationStatus) {
		this.id = id;
		this.companyName = companyName;
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.hrmsVerificationStatus = hrmsVerificationStatus;
	}
	

}
