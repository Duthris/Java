package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CompanyService;
import kodlama.io.hrms.dataAccess.abstracts.CompanyDao;
import kodlama.io.hrms.entities.concretes.Company;


@Service
public class CompanyManager implements CompanyService {
	
	private CompanyDao companyDao;

	public CompanyManager(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public List<Company> getAll() {
		return this.companyDao.findAll();
	}
	
	

}
