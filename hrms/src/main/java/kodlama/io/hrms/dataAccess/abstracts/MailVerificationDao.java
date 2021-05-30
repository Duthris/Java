package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.MailVerification;

public interface MailVerificationDao extends JpaRepository<MailVerification, Integer>{
	List<MailVerification> findByUserId(int userId);

}
