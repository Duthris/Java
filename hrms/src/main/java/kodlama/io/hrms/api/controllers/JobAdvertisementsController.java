package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllSorted")
	DataResult<List<JobAdvertisement>> getAllSorted() {
		return this.jobAdvertisementService.getAllSorted();
	}
	
	@PostMapping("/getAllByCompanyName")
	DataResult<List<JobAdvertisement>> getAllByCompanyName(@RequestParam String companyName) {
		return this.jobAdvertisementService.getAllByCompanyName(companyName);
	}
	
	@PostMapping("/getAllByCompanyId")
	DataResult<List<JobAdvertisement>> getAllByCompanyId(@RequestParam int id) {
		return this.jobAdvertisementService.getAllByCompanyId(id);
	}
	
	@PutMapping("/activate")
	Result activate(@RequestParam("id") int id, @RequestParam("activationStatus") boolean activationStatus) {
		return this.jobAdvertisementService.activate(id, activationStatus);
	}
	
	@PostMapping("/add")
	Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}

}
