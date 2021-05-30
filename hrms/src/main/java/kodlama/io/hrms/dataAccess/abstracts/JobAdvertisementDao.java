package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> getAllByActivationStatusTrue();
	List<JobAdvertisement> getAllByActivationStatusTrue(Sort sort);
	List<JobAdvertisement> getAllByEmployerId(int id);
	List<JobAdvertisement> getAllByEmployer_CompanyName(String companyName);
}
