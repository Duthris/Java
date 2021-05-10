package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateService {
	List<Candidate> getAll();

}
