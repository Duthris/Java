package kodlama.io.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.CandidateCvService;
import kodlama.io.hrms.core.adapters.abstracts.ImageAdapterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateCvDao;
import kodlama.io.hrms.dataAccess.abstracts.CandidateJobExperienceDao;
import kodlama.io.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlama.io.hrms.dataAccess.abstracts.CandidateSchoolDao;
import kodlama.io.hrms.dataAccess.abstracts.CandidateTalentDao;
import kodlama.io.hrms.entities.concretes.CandidateCv;
import kodlama.io.hrms.entities.concretes.CandidateJobExperience;
import kodlama.io.hrms.entities.concretes.CandidateLanguage;
import kodlama.io.hrms.entities.concretes.CandidateSchool;
import kodlama.io.hrms.entities.concretes.CandidateTalent;
import net.bytebuddy.asm.Advice.Return;
import net.bytebuddy.asm.Advice.This;

@Service
public class CandidateCvManager implements CandidateCvService {
	
	private CandidateCvDao candidateCvDao;
	private CandidateTalentDao candidateTalentDao;
	private CandidateLanguageDao candidateLanguageDao;
	private CandidateSchoolDao candidateSchoolDao;
	private CandidateJobExperienceDao candidateJobExperienceDao;
	private ImageAdapterService ImageAdapterService;

	
	@Autowired
	public CandidateCvManager(CandidateCvDao candidateCvDao, CandidateTalentDao candidateTalentDao,
			CandidateLanguageDao candidateLanguageDao, CandidateSchoolDao candidateSchoolDao,
			CandidateJobExperienceDao candidateJobExperienceDao,
			kodlama.io.hrms.core.adapters.abstracts.ImageAdapterService imageAdapterService) 
	
	{
		this.candidateCvDao = candidateCvDao;
		this.candidateTalentDao = candidateTalentDao;
		this.candidateLanguageDao = candidateLanguageDao;
		this.candidateSchoolDao = candidateSchoolDao;
		this.candidateJobExperienceDao = candidateJobExperienceDao;
		ImageAdapterService = imageAdapterService;
	}

	@Override
	public DataResult<List<CandidateCv>> getAll() {
		return new SuccessDataResult<List<CandidateCv>>
		(this.candidateCvDao.findAll(), "All Candidates' Cv's are Listed!");
	}

	@Override
	public Result add(CandidateCv candidateCv) {
		var tempCv = this.candidateCvDao.save(candidateCv);
		
		if (tempCv != null) {
			if (tempCv.getJobExperiences() != null) {
				for (CandidateJobExperience candidateJobExperience : tempCv.getJobExperiences()) {
					candidateJobExperience.setCandidateCv(tempCv);
					candidateJobExperience.setId(tempCv.getId());
					this.candidateJobExperienceDao.save(candidateJobExperience);
				}
			}
			
			if (tempCv.getSchools() != null) {
				for (CandidateSchool candidateSchool : tempCv.getSchools()) {
					candidateSchool.setCandidateCv(tempCv);
					candidateSchool.setId(tempCv.getId());
					this.candidateSchoolDao.save(candidateSchool);
				}
			}
			
			if (tempCv.getTalents() != null) {
				for (CandidateTalent candidateTalent : tempCv.getTalents()) {
					candidateTalent.setCandidateCv(tempCv);
					candidateTalent.setId(tempCv.getId());
					this.candidateTalentDao.save(candidateTalent);
				}
			}
			
			
			if (tempCv.getLanguages() != null) {
				for (CandidateLanguage candidateLanguage : tempCv.getLanguages()) {
					candidateLanguage.setCandidateCv(tempCv);
					candidateLanguage.setId(tempCv.getId());
					this.candidateLanguageDao.save(candidateLanguage);
				}
			}
			
		}
		
		return new SuccessResult("Candidate's Cv is Added!");
	}

	@Override
	public Result uploadCvAvatar(int id, MultipartFile multipartFile) throws IOException {
		var upload = this.ImageAdapterService.upload(multipartFile);
		var link = upload.getData().get("url");
		
		CandidateCv tempCv = this.candidateCvDao.getOne(id);
		tempCv.setAvatarLink(link.toString());
		this.candidateCvDao.save(tempCv);
		
		return new SuccessResult("Upload Succeed!");
	}

	@Override
	public DataResult<List<CandidateCv>> getByCandidateId(int id) {
		return new SuccessDataResult<List<CandidateCv>>
		(this.candidateCvDao.getByCandidateId(id));
	}

	@Override
	public DataResult<CandidateCv> update(CandidateCv candidateCv) {
		CandidateCv tempCv = this.candidateCvDao.findById(candidateCv.getId());
		
		if (candidateCv.getCoverLetter() != null) {
			tempCv.setCoverLetter(candidateCv.getCoverLetter());
		}
		
		if (candidateCv.getAvatarLink() != null) {
			tempCv.setAvatarLink(candidateCv.getAvatarLink());
		}
		
		if (candidateCv.getGithubLink() != null) {
			tempCv.setGithubLink(candidateCv.getGithubLink());
		}
		
		if (candidateCv.getLinkedinLink() != null) {
			tempCv.setLinkedinLink(candidateCv.getLinkedinLink());
		}
		
		if (candidateCv.getJobExperiences() != null) {
			tempCv.setJobExperiences(candidateCv.getJobExperiences());
		}
		
		if (candidateCv.getLanguages() != null) {
			tempCv.setLanguages(candidateCv.getLanguages());
		}
		
		if (candidateCv.getTalents() != null) {
			tempCv.setTalents(candidateCv.getTalents());
		}
		
		if (candidateCv.getSchools() != null) {
			tempCv.setSchools(candidateCv.getSchools());
		}
		
		if (candidateCv.isActive() != tempCv.isActive()) {
			tempCv.setActive(candidateCv.isActive());
		}
		
		
		return new SuccessDataResult<CandidateCv>
		(this.candidateCvDao.save(tempCv), "Cv infos are updated!");
	}

}
