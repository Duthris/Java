package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.CandidateSchool;

public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer>{
	List<CandidateSchool> getByCandidateCvId(int id);
	CandidateSchool findById(int id);
	
	@Query("From CandidateSchool cd where candidates_cv_id =:id order by graduation_date, is_graduated desc")
	List<CandidateSchool> getCandidateSchoolsOrderByGraduationDateDesc(int id);
	
}
