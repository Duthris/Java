package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerValidationService {
	public Result validateEmployer(Employer employer);

}
