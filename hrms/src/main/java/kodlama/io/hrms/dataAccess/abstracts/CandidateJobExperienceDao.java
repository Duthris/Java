package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.CandidateJobExperience;

public interface CandidateJobExperienceDao extends JpaRepository<CandidateJobExperience, Integer>{
	
	@Query("From CandidateJobExperience cj where candidates_cv_id =:id order by starting_date, is_quited desc")
	List<CandidateJobExperience> getCandidateJobExperienceByStartingDateDesc(int id);

}
