package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Department;

public interface DepartmentService {
	DataResult<List<Department>> getAll();
	Result add(Department department);
	Result update(Department department);
	Result delete(Department department);
}
