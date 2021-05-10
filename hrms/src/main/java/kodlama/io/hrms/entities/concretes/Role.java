package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Roles")
public class Role {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="role_name")
	private String roleName;
	
	public Role() { }

	public Role(int id, int userId, String roleName) {
		this.id = id;
		this.userId = userId;
		this.roleName = roleName;
	}

}
