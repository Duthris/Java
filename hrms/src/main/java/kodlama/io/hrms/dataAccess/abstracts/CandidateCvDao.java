package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.CandidateCv;

public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{
	List<CandidateCv> getByCandidateId(int id);
	boolean existsById(int id);
	
	CandidateCv findById(int id);
	
	CandidateCv getByCandidate(Candidate candidate);
}
