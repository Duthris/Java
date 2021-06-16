package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.WorkingMethodService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.WorkingMethodDao;
import kodlama.io.hrms.entities.concretes.WorkingMethod;
import net.bytebuddy.asm.Advice.This;

@Service
public class WorkingMethodManager implements WorkingMethodService {
	
	private WorkingMethodDao workingMethodDao;

	@Autowired
	public WorkingMethodManager(WorkingMethodDao workingMethodDao) {
		this.workingMethodDao = workingMethodDao;
	}

	@Override
	public DataResult<List<WorkingMethod>> getAll() {
		return new SuccessDataResult<List<WorkingMethod>>
		(this.workingMethodDao.findAll(), "All working methods are listed!");
	}

	@Override
	public DataResult<WorkingMethod> getById(int id) {
		return new SuccessDataResult<WorkingMethod>
		(this.workingMethodDao.getById(id), "Searched working method is found!");
	}

	@Override
	public Result add(WorkingMethod workingMethod) {
		this.workingMethodDao.save(workingMethod);
		return new SuccessResult("Working method is added to system!");
	}

}
