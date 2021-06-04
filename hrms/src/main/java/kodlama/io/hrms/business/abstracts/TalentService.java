package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Talent;

public interface TalentService {
	
	DataResult<List<Talent>> getAll();
	
	Result add(Talent talent);
	
}
