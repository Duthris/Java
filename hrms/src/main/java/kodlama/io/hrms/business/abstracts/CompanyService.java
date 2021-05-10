package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.entities.concretes.Company;

public interface CompanyService {
	List<Company> getAll();

}
