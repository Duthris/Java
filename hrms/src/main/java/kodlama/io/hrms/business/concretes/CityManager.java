package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CityDao;
import kodlama.io.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {
	
	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>
		(this.cityDao.findAll(), "All Cities are listed!");
	}

	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult(city.getCityName() + " is saved!");
	}

	@Override
	public Result update(City city) {
		City tempCity = this.cityDao.findById(city.getId());
		
		if (city.getCityName() != null) {
			tempCity.setCityName(city.getCityName());
		}
		
		return new SuccessResult(city.getCityName() + " is updated successfully!");
	}
	
	
}
