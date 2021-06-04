package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.TalentService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.TalentDao;
import kodlama.io.hrms.entities.concretes.Talent;

@Service
public class TalentManager implements TalentService {
	
	private TalentDao talentDao;
	
	
	@Autowired
	public TalentManager(TalentDao talentDao) {
		this.talentDao = talentDao;
	}



	@Override
	public DataResult<List<Talent>> getAll() {
		return new SuccessDataResult<List<Talent>>
		(this.talentDao.findAll(),"All Talents are Listed!");
	}


	@Override
	public Result add(Talent talent) {
		this.talentDao.save(talent);
		return new SuccessResult("Talent is successfully added!");
	}

}
