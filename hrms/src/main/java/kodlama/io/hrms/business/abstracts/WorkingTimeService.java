package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {
	DataResult<List<WorkingTime>> getAll();
	DataResult<WorkingTime> getById(int id);
	Result add(WorkingTime workingTime);
}
