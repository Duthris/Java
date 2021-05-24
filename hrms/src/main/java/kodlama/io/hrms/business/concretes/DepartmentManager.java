package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.DepartmentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.DepartmentDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {
	
	private DepartmentDao departmentDao;

	public DepartmentManager(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public DataResult<List<Department>> getAll() {
		return new SuccessDataResult<List<Department>>(this.departmentDao.findAll(), "Departments are listed!");
	}

	@Override
	public Result add(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Department department) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
