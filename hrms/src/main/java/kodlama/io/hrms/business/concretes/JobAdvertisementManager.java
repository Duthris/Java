package kodlama.io.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CityDao;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.dataAccess.abstracts.WorkingMethodDao;
import kodlama.io.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;
	private CityDao cityDao;
	private JobPositionDao jobPositionDao;
	private WorkingMethodDao workingMethodDao;
	private WorkingTimeDao workingTimeDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerDao employerDao, CityDao cityDao, 
			JobPositionDao jobPositionDao, WorkingMethodDao workingMethodDao, WorkingTimeDao workingTimeDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
		this.jobPositionDao = jobPositionDao;
		this.workingMethodDao = workingMethodDao;
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getAllByActivationStatusTrue(), "All Active Job Advertisements are successfully Listed.");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllByActivationStatusFalse() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getAllByActivationStatusFalse(), "All Passive Job Advertisements are successfully Listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "createdDate");
		return new SuccessDataResult<List<JobAdvertisement>> 
		(this.jobAdvertisementDao.getAllByActivationStatusTrue(sort), "All Job Advertisements are Listed in Descending Order!");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByCompanyId(int id) {
		if (!this.employerDao.existsById(id)) {
			return new ErrorDataResult<List<JobAdvertisement>>("Error: Invalid Company / Employer ID!");
		}
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getAllByEmployerId(id), "Job Advertisements are Listed for Company ID = " + id);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByCompanyName(String companyName) {
		if (this.employerDao.findAllByCompanyName(companyName).isEmpty()) {
			return new ErrorDataResult<List<JobAdvertisement>>("Error: Invalid Company Name!");
		}
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.getAllByEmployer_CompanyName(companyName), "Job Advertisements are Listed for Company Name = " + companyName);
	}

	@Override
	public Result add(JobAdvertisementDto jobAdvertisementDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		
		jobAdvertisement.setEmployer(this.employerDao.getOne(jobAdvertisementDto.getEmployerId()));
		jobAdvertisement.setCity(this.cityDao.getOne(jobAdvertisementDto.getCityId()));
		jobAdvertisement.setDescription(jobAdvertisementDto.getDescription());
		jobAdvertisement.setExpirationDate(jobAdvertisementDto.getExpirationDate());
		jobAdvertisement.setJobPosition(this.jobPositionDao.getOne(jobAdvertisementDto.getJobPositionId()));
		jobAdvertisement.setMaxSalary(jobAdvertisementDto.getMaxSalary());
		jobAdvertisement.setMinSalary(jobAdvertisementDto.getMinSalary());
		jobAdvertisement.setQuota(jobAdvertisementDto.getQuota());
		jobAdvertisement.setWorkingMethod(this.workingMethodDao.getOne(jobAdvertisementDto.getWorkingMethodId()));
		jobAdvertisement.setWorkingTime(this.workingTimeDao.getOne(jobAdvertisementDto.getWorkingTimeId()));
		jobAdvertisement.setCreatedDate(LocalDateTime.now());
		jobAdvertisement.setActivationStatus(false);
		
		if (!isAllFieldsFilled(jobAdvertisement)) {
			return new ErrorResult("Error: All fields must be filled!");
		}
		
		if (!isCityExist(jobAdvertisement)) {
			return new ErrorResult("Error: City is not exist!");
		}
		
		if (!isExistEmployer(jobAdvertisement)) {
			return new ErrorResult("Error: Employer is not exist!");
		}
		
		if (!isQuotaDefined(jobAdvertisement)) {
			return new ErrorResult("Error: You can have minimum 1 quota for your job!");
		}
		
		if (!isDifferentCreatedAndExpirationDate(jobAdvertisement)) {
			return new ErrorResult("Error: Expiration Date must be later than Creation Date"); 
		}
		
		else {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("Successfully Added!");			
		}
	}

	@Override
	public Result activate(int id, boolean activationStatus) {
		JobAdvertisement jobAdvertisementToActivate = this.jobAdvertisementDao.findById(id).orElse(null);
		
		jobAdvertisementToActivate.setActivationStatus(activationStatus);
		
		this.jobAdvertisementDao.save(jobAdvertisementToActivate);
		return new SuccessResult("Updated: Activation Status is Updated as " + Boolean.toString(activationStatus));
	}
	
	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		if (!this.jobAdvertisementDao.existsById(id)) {
			return new ErrorDataResult<JobAdvertisement>("Error: Job Advertisement could not be found!");
		}
		
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getOne(id),"Job Advertisement Found.");
	}
	
	
	private boolean isCityExist(JobAdvertisement jobAdvertisement) {
		if (this.cityDao.existsById(jobAdvertisement.getCity().getId())) {
			return true;			
		}
		
		return false;
	}
	
	
	private boolean isExistEmployer(JobAdvertisement jobAdvertisement) {
		if (this.employerDao.existsById(jobAdvertisement.getEmployer().getId())) {
			return true;
		}
		
		return false;
	}
	
	
	private boolean isAllFieldsFilled(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getDescription().length() != 0 && jobAdvertisement.getExpirationDate() != null) {
			return true;
		}
		
		return false;
	}
	
	private boolean isQuotaDefined(JobAdvertisement jobAdvertisement) {
		if (jobAdvertisement.getQuota() > 0) {
			return true;
		}
		
		return false;
	}
	
	
	private boolean isDifferentCreatedAndExpirationDate(JobAdvertisement jobAdvertisement) {
		if (!jobAdvertisement.getCreatedDate().equals(jobAdvertisement.getExpirationDate())) {
			return true;
		}
		
		return false;
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("Successfully Deleted!");
	}

}
