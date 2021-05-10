package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="verification_status")
	private boolean verificationStatus;
	
	public User() { }

	public User(int id, String email, String password, boolean verificationStatus) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.verificationStatus = verificationStatus;
	}

}
