package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.WorkingMethod;

public interface WorkingMethodService {
	DataResult<List<WorkingMethod>> getAll();
	DataResult<WorkingMethod> getById(int id);
	Result add(WorkingMethod workingMethod);
}
