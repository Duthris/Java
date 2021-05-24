package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Company;

public interface CompanyService {
	DataResult<List<Company>> getAll();
	Result add(Company company);
	Result update(Company company);
	Result delete(Company company);
}
