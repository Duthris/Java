package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.WorkingMethod;

public interface WorkingMethodDao extends JpaRepository<WorkingMethod, Integer>{
	WorkingMethod getById(int id);

}
