package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.CandidateJobExperience;

public interface CandidateJobExperienceService {
	
	DataResult<List<CandidateJobExperience>> getAll();
	DataResult<List<CandidateJobExperience>> orderCandidateJobExperiencesByStartingDateDesc(int id);

}
