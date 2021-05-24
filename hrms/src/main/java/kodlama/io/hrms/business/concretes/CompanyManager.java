package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CompanyService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.CompanyDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Company;


@Service
public class CompanyManager implements CompanyService {
	
	private CompanyDao companyDao;

	public CompanyManager(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public DataResult<List<Company>> getAll() {
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll(), "Companies are listed!");
	}

	@Override
	public Result add(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Company company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(Company company) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
