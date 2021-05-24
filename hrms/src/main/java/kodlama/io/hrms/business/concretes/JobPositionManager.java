package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.JobPosition;


@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;

	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job Positions are listed!");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if (jobPosition.getPositionName().length() <= 0) {
			return new ErrorResult("Job Position Name cannot be NULL!");
		}
		
		if (getByPositionName(jobPosition.getPositionName()) != null) {
			return new ErrorResult("This Job Position is already EXIST!");			
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job Position is added successfully!");
	}

	@Override
	public Result update(JobPosition jobPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobPosition jobPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobPosition getByPositionName(String positionName) {
		return this.jobPositionDao.findByPositionName(positionName);
	}
	
	
	

}
