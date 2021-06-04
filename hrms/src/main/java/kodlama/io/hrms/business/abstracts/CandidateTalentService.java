package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CandidateTalent;
import kodlama.io.hrms.entities.concretes.Talent;

public interface CandidateTalentService {
	
	DataResult<List<CandidateTalent>> getAll();
	
	DataResult<List<CandidateTalent>> getByCandidateCvId(int id);
	
	Result addTalentToCv(Talent talent, int candidateId);

}
