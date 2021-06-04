package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.User;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findAllByEmail(String email);
	Candidate findAllByNationalityId(String nationalityId);
	Candidate getById(int id);
}
