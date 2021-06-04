package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateTalentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.CandidateTalentDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.CandidateCv;
import kodlama.io.hrms.entities.concretes.CandidateLanguage;
import kodlama.io.hrms.entities.concretes.CandidateTalent;
import kodlama.io.hrms.entities.concretes.Talent;

@Service
public class CandidateTalentManager implements CandidateTalentService {
	
	private CandidateTalentDao candidateTalentDao;
	private CandidateDao candidateDao;
	private CandidateCvDao candidateCvDao;
	

	@Autowired
	public CandidateTalentManager(CandidateTalentDao candidateTalentDao, CandidateDao candidateDao, CandidateCvDao candidateCvDao) {
		this.candidateTalentDao = candidateTalentDao;
		this.candidateDao = candidateDao;
		this.candidateCvDao = candidateCvDao;
	}

	@Override
	public DataResult<List<CandidateTalent>> getAll() {
		return new SuccessDataResult<List<CandidateTalent>>
		(this.candidateTalentDao.findAll(), "All Candidates' Talents are listed!");
	}

	@Override
	public DataResult<List<CandidateTalent>> getByCandidateCvId(int id) {
		return new SuccessDataResult<List<CandidateTalent>>
		(this.candidateTalentDao.getByCandidateCvId(id));
	}

	@Override
	public Result addTalentToCv(Talent talent, int candidateId) {
		
		Candidate candidate = this.candidateDao.getById(candidateId);
		
		CandidateCv cv = this.candidateCvDao.getByCandidate(candidate);
		
		CandidateTalent candidateTalent = new CandidateTalent(cv, talent);
		
		
		this.candidateTalentDao.save(candidateTalent);
		
		return new SuccessResult("Talent is added to Cv!");
	}

}
