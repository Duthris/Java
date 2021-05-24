package kodlama.io.hrms.adapters;

import kodlama.io.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {
	boolean checkIfRealPerson(Candidate candidate);
}
