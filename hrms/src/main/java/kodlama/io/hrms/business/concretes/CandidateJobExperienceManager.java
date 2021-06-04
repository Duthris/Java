package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateJobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlama.io.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import kodlama.io.hrms.entities.concretes.CandidateJobExperience;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService {
	
	private CandidateJobExperienceDao candidateJobExperienceDao;
	private CandidateCvDao candidateCvDao;
	
	
	public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao,CandidateCvDao candidateCvDao) {
		this.candidateJobExperienceDao = candidateJobExperienceDao;
		this.candidateCvDao = candidateCvDao;
	}


	@Override
	public DataResult<List<CandidateJobExperience>> getAll() {
		
		return new SuccessDataResult<List<CandidateJobExperience>>
		(this.candidateJobExperienceDao.findAll(), "Job Experiences of Candidates are Listed!");
		
	}


	@Override
	public DataResult<List<CandidateJobExperience>> orderCandidateJobExperiencesByStartingDateDesc(int id) {
		
		if (this.candidateCvDao.existsById(id)) {
			return new SuccessDataResult<List<CandidateJobExperience>>
			(this.candidateJobExperienceDao.getCandidateJobExperienceByStartingDateDesc(id), "Searched Candidate's Job Experiences are Listed!");
		}
		
		return new ErrorDataResult<List<CandidateJobExperience>>("Invalid Cv ID!");
	}
	
	

}
