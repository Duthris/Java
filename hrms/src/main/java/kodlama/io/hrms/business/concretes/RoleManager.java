package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.RoleService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.RoleDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Role;

@Service
public class RoleManager implements RoleService {
	
	private RoleDao roleDao;

	public RoleManager(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public DataResult<List<Role>> getAll() {
		return new SuccessDataResult<List<Role>>(this.roleDao.findAll(), "Roles are listed!");
	}

	@Override
	public Result add(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Role role) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
