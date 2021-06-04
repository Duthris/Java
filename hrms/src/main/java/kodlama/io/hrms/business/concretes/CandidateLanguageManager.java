package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.CandidateCv;
import kodlama.io.hrms.entities.concretes.CandidateLanguage;
import kodlama.io.hrms.entities.concretes.Language;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {
	
	private CandidateLanguageDao candidateLanguageDao;
	private CandidateCvDao candidateCvDao;
	private CandidateDao candidateDao;

	@Autowired
	public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao, CandidateCvDao candidateCvDao, CandidateDao candidateDao) {
		this.candidateLanguageDao = candidateLanguageDao;
		this.candidateCvDao = candidateCvDao;
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<CandidateLanguage>> getAll() {
		return new SuccessDataResult<List<CandidateLanguage>>
		(this.candidateLanguageDao.findAll(), "All Candidates' languages are listed.");
	}

	@Override
	public DataResult<List<CandidateLanguage>> getByCandidateCvId(int id) {
		return new SuccessDataResult<List<CandidateLanguage>>
		(this.candidateLanguageDao.getByCandidateCvId(id));
	}

	
	@Override
	public Result addLanguageToCv(Language language, int candidateId) {
		
		Candidate candidate = this.candidateDao.getById(candidateId);
		
		CandidateCv cv = this.candidateCvDao.getByCandidate(candidate);
		
		CandidateLanguage candidateLanguage = new CandidateLanguage(cv, language);
		
		
		this.candidateLanguageDao.save(candidateLanguage);
		
		return new SuccessResult("Language is added to Cv!");
	}
	
	
	
	

}
