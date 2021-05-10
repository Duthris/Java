package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.entities.concretes.Department;

public interface DepartmentService {
	List<Department> getAll();

}
