package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.DepartmentService;
import kodlama.io.hrms.dataAccess.abstracts.DepartmentDao;
import kodlama.io.hrms.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {
	
	private DepartmentDao departmentDao;

	public DepartmentManager(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Department> getAll() {
		return this.departmentDao.findAll();
	}
	
	
	
	

}
