package kodlama.io.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getAllSorted();
	DataResult<List<JobAdvertisement>> getAllByCompanyId(int id);
	DataResult<List<JobAdvertisement>> getAllByCompanyName(String companyName);
	
	Result add(JobAdvertisement jobAdvertisement);
	Result activate(int id, boolean activationStatus);
}
