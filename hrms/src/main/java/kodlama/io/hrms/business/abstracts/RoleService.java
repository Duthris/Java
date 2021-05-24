package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Role;

public interface RoleService {
	DataResult<List<Role>> getAll();
	Result add(Role role);
	Result update(Role role);
	Result delete(Role role);
}
