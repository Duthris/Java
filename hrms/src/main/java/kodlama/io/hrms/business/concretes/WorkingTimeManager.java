package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.WorkingTimeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlama.io.hrms.entities.concretes.WorkingTime;

@Service
public class WorkingTimeManager implements WorkingTimeService {
	
	private WorkingTimeDao workingTimeDao;

	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		return new SuccessDataResult<List<WorkingTime>>
		(this.workingTimeDao.findAll(), "All Working Time Ways are Listed!");
	}

	@Override
	public DataResult<WorkingTime> getById(int id) {
		return new SuccessDataResult<WorkingTime>
		(this.workingTimeDao.getById(id), "Searched time is found!");
	}

	@Override
	public Result add(WorkingTime workingTime) {
		this.workingTimeDao.save(workingTime);
		return new SuccessResult("Working Time is added to System!");
	}

}
