package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.CandidateLanguage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer>{
	
	List<CandidateLanguage> getByCandidateCvId(int id);

}
