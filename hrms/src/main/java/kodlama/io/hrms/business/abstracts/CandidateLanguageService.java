package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CandidateLanguage;
import kodlama.io.hrms.entities.concretes.Language;

public interface CandidateLanguageService {
	
	DataResult<List<CandidateLanguage>> getAll();
	
	DataResult<List<CandidateLanguage>> getByCandidateCvId(int id);
	
	Result addLanguageToCv(Language language, int candidateId);
}
