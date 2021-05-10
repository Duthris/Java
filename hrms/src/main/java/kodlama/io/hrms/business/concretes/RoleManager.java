package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.RoleService;
import kodlama.io.hrms.dataAccess.abstracts.RoleDao;
import kodlama.io.hrms.entities.concretes.Role;

@Service
public class RoleManager implements RoleService {
	
	private RoleDao roleDao;

	public RoleManager(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public List<Role> getAll() {
		return this.roleDao.findAll();
	}
	
	

}
