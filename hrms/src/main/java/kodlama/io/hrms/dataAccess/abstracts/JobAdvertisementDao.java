package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> getAllByActivationStatusTrue();
	List<JobAdvertisement> getAllByActivationStatusTrue(Sort sort);
	List<JobAdvertisement> getAllByEmployerId(int id);
	List<JobAdvertisement> getAllByEmployer_CompanyName(String companyName);
	
	@Query("From JobAdvertisement where activationStatus = false order by expiration_date asc")
	List<JobAdvertisement> getAllByActivationStatusFalse();
}
